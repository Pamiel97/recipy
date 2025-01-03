package org.generation.italy.recipy.model.services.abstraction;

import org.generation.italy.recipy.model.entities.RecipeStep;

import java.util.Optional;

public interface RecipeStepService {
    RecipeStep createRecipeStep(RecipeStep recipeStep);
    Optional<RecipeStep> findById(long id);
    Optional<RecipeStep> updateRecipeStep(RecipeStep recipeStep);

}
