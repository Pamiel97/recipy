package org.generation.italy.recipy.model.services.abstraction;

import org.generation.italy.recipy.model.entities.Recipe;

import java.util.List;

public interface SuggestedRecipeService {
    List<Recipe> suggestedRecipesForUserPref(long id);
}
