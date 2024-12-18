package org.generation.italy.recipy.model.services.implementation;

import org.generation.italy.recipy.model.entities.Pantry;
import org.generation.italy.recipy.model.entities.Recipe;
import org.generation.italy.recipy.model.exceptions.EmptyListException;
import org.generation.italy.recipy.model.repositories.SuggestedRecipeRepositoryJpa;
import org.generation.italy.recipy.model.services.abstraction.PantryService;
import org.generation.italy.recipy.model.services.abstraction.SuggestedRecipeService;
import org.springframework.stereotype.Service;

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
    public List<Recipe> findRecipesByAvailablePantries() throws EmptyListException{
        List<Pantry> pantries = pantryService.findAllAvailableIngredients();
        if(pantries.isEmpty()) {
            throw new EmptyListException("La lista di ingredienti è vuota.");
        }
        return suggestedRecipeRepo.findByAvailablePantry();

    }
}
