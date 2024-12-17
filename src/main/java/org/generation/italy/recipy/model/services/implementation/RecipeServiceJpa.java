package org.generation.italy.recipy.model.services.implementation;

import org.generation.italy.recipy.model.entities.Recipe;
import org.generation.italy.recipy.model.repositories.RecipeRepositoryJPA;
import org.generation.italy.recipy.model.repositories.RecipeStepRepositoryJPA;
import org.generation.italy.recipy.model.services.abstraction.RecipeService;

import java.util.Optional;

public class RecipeServiceJpa implements RecipeService {
    private RecipeRepositoryJPA repo;

    public RecipeServiceJpa(RecipeRepositoryJPA repo){
        this.repo = repo;
    }


    @Override
    public Recipe createRecipe(Recipe recipe) {
        return repo.save(recipe);
    }

    @Override
    public boolean deleteRecipeById(long id) {
        if(!repo.existsById(id)){
            return false;
        }
        repo.deleteById(id);
        return true;
    }

    @Override
    public boolean updateRecipe(Recipe recipe) {
        if(!repo.existsById(recipe.getId())){
            return false;
        }
        repo.save(recipe);
        return true;
    }

    @Override
    public Optional<Recipe> findById(long id) {
        return repo.findById(id);
    }
}
