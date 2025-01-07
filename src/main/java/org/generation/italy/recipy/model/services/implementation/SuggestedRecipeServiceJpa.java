package org.generation.italy.recipy.model.services.implementation;

import org.generation.italy.recipy.model.entities.Pantry;
import org.generation.italy.recipy.model.entities.Recipe;
import org.generation.italy.recipy.model.repositories.SuggestedRecipeRepositoryJpa;
import org.generation.italy.recipy.model.services.abstraction.PantryService;
import org.generation.italy.recipy.model.services.abstraction.SuggestedRecipeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<Recipe> findAllRecipesShorterThan(int minutes) {
        return suggestedRecipeRepo.findAllRecipesShorterThan(minutes);
    }

    @Override
    public List<Recipe> recipesOkToUserIntolerancesAndAllergies(long userId) {
        return suggestedRecipeRepo.recipesOkToUserIntolerancesAndAllergies(userId);
    }

    @Override
    public List<Recipe> findRecipesForUserProfile(long userId) {
        return suggestedRecipeRepo.findRecipesForUserProfile(userId);
    }

    @Override
    public List<Recipe> recipesOkToUser(long userId) {
        List<Recipe> byDiet = suggestedRecipeRepo.recipesOkToUserDietType(userId);
        List<Recipe> byIntAndAll = suggestedRecipeRepo.recipesOkToUserIntolerancesAndAllergies(userId);
        List<Recipe> byProfile = suggestedRecipeRepo.findRecipesForUserProfile(userId);

        List<Recipe> test = byDiet.stream()
                .filter(byIntAndAll::contains)
                .filter(byProfile::contains)
                .distinct().toList();

        return test;
    }


    //mirko
    @Override
    public List<Recipe> findRecipesByAvailablePantries(long userId){
        List<Pantry> pantries = pantryService.findPantriesByUserId(userId);
        if(pantries.isEmpty()) {
            return new ArrayList<>();
        }
        return suggestedRecipeRepo.findByAvailablePantry(userId);

    }
}
