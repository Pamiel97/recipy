package org.generation.italy.recipy.model.services.abstraction;

import org.generation.italy.recipy.model.entities.Recipe;

import java.util.Optional;

public interface RecipeService {
    Recipe createRecipe(Recipe recipe);
    boolean deleteRecipeById(long id);
    boolean updateRecipe(Recipe recipe);
    Optional<Recipe> findById(long id);


}
