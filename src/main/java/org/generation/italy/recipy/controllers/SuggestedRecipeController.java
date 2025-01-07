package org.generation.italy.recipy.controllers;

import org.generation.italy.recipy.dtos.PantryDto;
import org.generation.italy.recipy.dtos.RecipeDto;
import org.generation.italy.recipy.model.entities.Recipe;
import org.generation.italy.recipy.model.entities.User;
import org.generation.italy.recipy.model.exceptions.EmptyListException;
import org.generation.italy.recipy.model.services.abstraction.SuggestedRecipeService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/home")
public class SuggestedRecipeController {
    private SuggestedRecipeService suggestedRecipeService;

    public SuggestedRecipeController(SuggestedRecipeService suggestedRecipeService) {
        this.suggestedRecipeService = suggestedRecipeService;
    }

    @CrossOrigin
    @GetMapping("/diet-compatible")
    public ResponseEntity<List<RecipeDto>> recipesOkToUserDietType(@AuthenticationPrincipal User user){
        List<RecipeDto> recipes = suggestedRecipeService.recipesOkToUserDietType(user.getId())
                .stream().map(RecipeDto::fromRecipe).toList();
        if (recipes.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipes);
    }

    @GetMapping("/shorter-than/{minutes}")
    public ResponseEntity<List<RecipeDto>> findAllRecipesShorterThan(@PathVariable int minutes){
        List<RecipeDto> recipes = suggestedRecipeService.findAllRecipesShorterThan(minutes)
                .stream().map(RecipeDto::fromRecipe).toList();
        if (recipes.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipes);
    }

    @CrossOrigin
    @GetMapping("/difficulty")
    public ResponseEntity<List<RecipeDto>> findRecipesForUserProfile(@AuthenticationPrincipal User user) {
        List<RecipeDto> recipes = suggestedRecipeService.findRecipesForUserProfile(user.getId())
                .stream().map(RecipeDto::fromRecipe).toList();
        if (recipes.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipes);
    }

    @CrossOrigin
    @GetMapping("/allergies-intolerances")
    public ResponseEntity<List<RecipeDto>> recipesOkToUserIntolerancesAndAllergies(@AuthenticationPrincipal User user){
        List<RecipeDto> recipes = suggestedRecipeService.recipesOkToUserIntolerancesAndAllergies(user.getId())
                .stream().map(RecipeDto::fromRecipe).toList();
        if (recipes.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipes);
    }

    @CrossOrigin
    @GetMapping("/user")
    public ResponseEntity<List<RecipeDto>> recipesOkToUser(@AuthenticationPrincipal User user){
        List<RecipeDto> recipes = suggestedRecipeService.recipesOkToUser(user.getId())
                .stream().map(RecipeDto::fromRecipe).toList();
        if (recipes.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipes);
    }



    //mirko
    @CrossOrigin
    @GetMapping("/recipes-by-pantries")
    public ResponseEntity<?> getRecipesByAvailablePantries(@AuthenticationPrincipal User user) {
        try {
            List<Recipe> recipes = suggestedRecipeService.findRecipesByAvailablePantries(user.getId());
            return ResponseEntity.ok(recipes.stream().map(RecipeDto::fromRecipe).toList());
        } catch (EmptyListException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
