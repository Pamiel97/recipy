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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class RecipeServiceJpa implements RecipeService {
    private RecipeRepositoryJPA repo;
    private UserRepositoryJPA userRepositoryJPA;
    private IngredientRepositoryJPA ingredientRepo;
    private RecipeStepRepositoryJPA recipeStepRepository;


    public RecipeServiceJpa(RecipeRepositoryJPA repo, UserRepositoryJPA userRepositoryJPA,IngredientRepositoryJPA ingredientRepo, RecipeStepRepositoryJPA recipeStepRepository){
        this.repo = repo;
        this.userRepositoryJPA = userRepositoryJPA;
        this.ingredientRepo = ingredientRepo;
        this.recipeStepRepository = recipeStepRepository;
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

        Recipe existingRecipe = optionalRecipe.get();

        for (RecipeStep step : updatedRecipe.getRecipeSteps()) {
            Optional<Ingredient> oi = ingredientRepo.findById(step.getIngredient().getId());
            if (oi.isEmpty()) {
                throw new EntityNotFoundException("Ingrediente con id: " + step.getIngredient().getId() + " non trovato");
            }
            step.setIngredient(oi.get());
        }

        for (RecipeStep step : updatedRecipe.getRecipeSteps()) {
            if (step.getId() != 0) {
                Optional<RecipeStep> optionalStep = recipeStepRepository.findById(step.getId());
                if (optionalStep.isPresent()) {
                    RecipeStep existingStep = optionalStep.get();
                    existingStep.setDescription(step.getDescription());
                    existingStep.setOrdinal(step.getOrdinal());
                    existingStep.setStepImgUrl(step.getStepImgUrl());
                    existingStep.setIngredient(step.getIngredient());
                } else {
                    throw new EntityNotFoundException("Step con id: " + step.getId() + " non trovato");
                }
            }
        }

        existingRecipe.setRecipeSteps(updatedRecipe.getRecipeSteps());

        return repo.save(existingRecipe);
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

    @Override
    public List<Recipe> findAllByUserId(long userId) {
        return repo.findByUserId(userId);
    }
}
