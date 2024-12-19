package org.generation.italy.recipy.model.services.implementation;

import org.generation.italy.recipy.model.entities.Pantry;
import org.generation.italy.recipy.model.entities.Recipe;
import org.generation.italy.recipy.model.exceptions.EmptyListException;
import org.generation.italy.recipy.model.repositories.SuggestedRecipeRepositoryJpa;
import org.generation.italy.recipy.model.services.abstraction.PantryService;
import org.generation.italy.recipy.model.services.abstraction.SuggestedRecipeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SuggestedRecipeServiceJpa implements SuggestedRecipeService {
    private SuggestedRecipeRepositoryJpa suggestedRecipeRepo;
    private PantryService pantryService;

    public SuggestedRecipeServiceJpa(SuggestedRecipeRepositoryJpa suggestedRecipeRepositoryJpa, PantryService pantryService) {
        this.suggestedRecipeRepo = suggestedRecipeRepositoryJpa;
        this.pantryService = pantryService;
    }

    @Override
    public List<Recipe> recipesOkToUserDietType(long userId) {
        return suggestedRecipeRepo.recipesOkToUserDietType(userId);
    }

//    @Override
//    public List<Recipe> findAllRecipesShorterThan(int minutes) {
//        return suggestedRecipeRepo.findAllRecipesShorterThan(minutes);
//    }


    //mirko
    @Override
    public List<Recipe> findRecipesByAvailablePantries(long userId){
        List<Pantry> pantries = pantryService.findPantriesByUserId(userId);
        if(pantries.isEmpty()) {
            return new ArrayList<>();
        }
        return suggestedRecipeRepo.findByAvailablePantry();

    }
}
