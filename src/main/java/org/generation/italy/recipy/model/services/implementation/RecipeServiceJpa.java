package org.generation.italy.recipy.model.services.implementation;

import org.generation.italy.recipy.model.entities.Ingredient;
import org.generation.italy.recipy.model.entities.Recipe;
import org.generation.italy.recipy.model.entities.RecipeStep;
import org.generation.italy.recipy.model.entities.User;
import org.generation.italy.recipy.model.exceptions.EntityNotFoundException;
import org.generation.italy.recipy.model.repositories.IngredientRepositoryJPA;
import org.generation.italy.recipy.model.repositories.RecipeRepositoryJPA;
import org.generation.italy.recipy.model.repositories.RecipeStepRepositoryJPA;
import org.generation.italy.recipy.model.repositories.UserRepositoryJPA;
import org.generation.italy.recipy.model.services.abstraction.RecipeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RecipeServiceJpa implements RecipeService {
    private RecipeRepositoryJPA repo;
    private UserRepositoryJPA userRepositoryJPA;
    private IngredientRepositoryJPA ingredientRepo;


    public RecipeServiceJpa(RecipeRepositoryJPA repo, UserRepositoryJPA userRepositoryJPA,IngredientRepositoryJPA ingredientRepo){
        this.repo = repo;
        this.userRepositoryJPA = userRepositoryJPA;
        this.ingredientRepo = ingredientRepo;
    }


    @Override
    public Recipe createRecipe(Recipe recipe, long userId) throws EntityNotFoundException {
        Optional<User> optionalUser = userRepositoryJPA.findById(userId);
        if(optionalUser.isEmpty()){
            throw new EntityNotFoundException("Utente con id: " + userId + " non è stato trovato" );
        }
        recipe.setUser(optionalUser.get());
        for (RecipeStep step: recipe.getRecipeSteps()){
           Optional<Ingredient> oi =  ingredientRepo.findById(step.getIngredient().getId());
           if(oi.isEmpty()){
               throw  new EntityNotFoundException("Ingrediente con id: " + step.getIngredient().getId() + " non è stato trovato");
           }
           step.setIngredient(oi.get());
        }

        return repo.save(recipe);

    }


    @Override
    public Optional<Recipe> findById(long id) {
        return repo.findById(id);
    }

    @Override
    public List<Recipe> findAll() {
        return repo.findAll();
    }

    @Override
    public Recipe updateRecipe(long id, Recipe updatedRecipe) throws EntityNotFoundException {
        Optional<Recipe> optionalRecipe = repo.findById(id);
        if (optionalRecipe.isEmpty()) {
            throw new EntityNotFoundException("Ricetta con id: " + id + " non trovata");
        }

        for (RecipeStep step: updatedRecipe.getRecipeSteps()){
            Optional<Ingredient> oi =  ingredientRepo.findById(step.getIngredient().getId());
            if(oi.isEmpty()){
                throw  new EntityNotFoundException("Ingrediente con id: " + step.getIngredient().getId() + " non è stato trovato");
            }
            step.setIngredient(oi.get());
        }

        return repo.save(updatedRecipe);
    }

    @Override
    public void deleteRecipe(long id) throws EntityNotFoundException {
        Optional<Recipe> existingRecipeOpt = repo.findById(id);
        if (existingRecipeOpt.isEmpty()) {
            throw new EntityNotFoundException("Ricetta con id: " + id + " non trovata");
        }
        Recipe existingRecipe = existingRecipeOpt.get();
        repo.delete(existingRecipe);
    }
}
