package org.generation.italy.recipy.controllers;

import org.generation.italy.recipy.dtos.RecipeDto;
import org.generation.italy.recipy.model.entities.Recipe;
import org.generation.italy.recipy.model.services.abstraction.SuggestedRecipeService;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/{id}")
    public ResponseEntity<List<RecipeDto>> recipesOkToUserDietType(@PathVariable long userId){
        List<RecipeDto> recipes = suggestedRecipeService.recipesOkToUserDietType(userId)
                .stream().map(RecipeDto::fromRecipe).toList();
        if (recipes.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipes);
    }

    //TODO scommentare e finire di implementare il metodo che trova le ricette più corte di x minuti
}