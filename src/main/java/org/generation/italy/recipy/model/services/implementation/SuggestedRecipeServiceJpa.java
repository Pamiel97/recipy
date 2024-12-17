package org.generation.italy.recipy.model.services.implementation;

import org.generation.italy.recipy.model.entities.Recipe;
import org.generation.italy.recipy.model.repositories.SuggestedRecipeRepositoryJpa;
import org.generation.italy.recipy.model.services.abstraction.SuggestedRecipeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuggestedRecipeServiceJpa implements SuggestedRecipeService {
    private SuggestedRecipeRepositoryJpa suggestedRecipeRepo;

    public SuggestedRecipeServiceJpa(SuggestedRecipeRepositoryJpa suggestedRecipeRepositoryJpa) {
        this.suggestedRecipeRepo = suggestedRecipeRepositoryJpa;
    }

    @Override
    public List<Recipe> recipesOkToUserDietType(long userId) {
        return suggestedRecipeRepo.recipesOkToUserDietType(userId);
    }

//    @Override
//    public List<Recipe> findAllRecipesShorterThan(int minutes) {
//        return suggestedRecipeRepo.findAllRecipesShorterThan(minutes);
//    }
}
