package org.generation.italy.recipy.controllers;

import org.generation.italy.recipy.dtos.PantryDto;
import org.generation.italy.recipy.dtos.RecipeDto;
import org.generation.italy.recipy.model.entities.Recipe;
import org.generation.italy.recipy.model.entities.User;
import org.generation.italy.recipy.model.exceptions.EmptyListException;
import org.generation.italy.recipy.model.services.abstraction.SuggestedRecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/api/home")
public class SuggestedRecipeController {
    private SuggestedRecipeService suggestedRecipeService;

    public SuggestedRecipeController(SuggestedRecipeService suggestedRecipeService) {
        this.suggestedRecipeService = suggestedRecipeService;
    }

    @GetMapping("/diet-compatible/{id}")
    public ResponseEntity<List<RecipeDto>> recipesOkToUserDietType(@PathVariable("id") long userId){
        List<RecipeDto> recipes = suggestedRecipeService.recipesOkToUserDietType(userId)
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

    @GetMapping("/difficulty/{id}")
    public ResponseEntity<List<RecipeDto>> findRecipesForUserProfile(@PathVariable long userId) {
        List<RecipeDto> recipes = suggestedRecipeService.findRecipesForUserProfile(userId)
                .stream().map(RecipeDto::fromRecipe).toList();
        if (recipes.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipes);
    }



    //mirko

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
