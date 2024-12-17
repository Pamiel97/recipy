package org.generation.italy.recipy.model.services.implementation;

import org.generation.italy.recipy.model.entities.Recipe;
import org.generation.italy.recipy.model.services.abstraction.SuggestedRecipeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuggestedRecipeServiceJpa implements SuggestedRecipeService {

    @Override
    public List<Recipe> recipesOkToUserDietType(long userId) {
        return List.of(); //TODO
    }
}
