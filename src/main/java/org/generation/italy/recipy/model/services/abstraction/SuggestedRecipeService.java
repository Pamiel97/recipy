package org.generation.italy.recipy.model.services.abstraction;

import org.generation.italy.recipy.model.entities.Recipe;
import org.generation.italy.recipy.model.exceptions.EmptyListException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SuggestedRecipeService {
    List<Recipe> recipesOkToUserDietType(long userId);
    List<Recipe> findAllRecipesShorterThan(int minutes);
//    List<Recipe> getRecipesForUserProfile(long userId);

    //mirko
    List<Recipe> findRecipesByAvailablePantries() throws EmptyListException;
}
