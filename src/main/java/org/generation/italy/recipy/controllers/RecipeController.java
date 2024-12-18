package org.generation.italy.recipy.controllers;

import org.generation.italy.recipy.dtos.RecipeDto;
import org.generation.italy.recipy.model.entities.Recipe;
import org.generation.italy.recipy.model.entities.User;
import org.generation.italy.recipy.model.exceptions.EntityNotFoundException;
import org.generation.italy.recipy.model.services.abstraction.IngredientService;
import org.generation.italy.recipy.model.services.abstraction.RecipeService;
import org.generation.italy.recipy.model.services.abstraction.RecipeStepService;
import org.generation.italy.recipy.model.services.implementation.IngredientServiceJpa;
import org.generation.italy.recipy.model.services.implementation.RecipeServiceJpa;
import org.generation.italy.recipy.model.services.implementation.RecipeStepServiceJpa;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("api/recipes")
public class RecipeController {
    RecipeService recipeService;
    RecipeStepService recipeStepService;
    IngredientService ingredientService;


    public RecipeController(RecipeService recipeService, RecipeStepService recipeStepService, IngredientService ingredientService){
        this.recipeService=recipeService;
        this.recipeStepService=recipeStepService;
        this.ingredientService=ingredientService;
    }

    @PostMapping
    public ResponseEntity<?> createRecipe(@RequestBody RecipeDto recipeDto, @AuthenticationPrincipal User user) {
        Recipe recipe = recipeDto.toRecipe();
        long userId = user.getId();
        try {
            Recipe saved = recipeService.createRecipe(recipe, userId);
            return ResponseEntity.ok(saved);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<RecipeDto>> getAllRecipe(){
        List<Recipe> allRecipe = recipeService.findAll();
        return ResponseEntity.ok(allRecipe.stream().map(RecipeDto::fromRecipe).toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRecipe(@PathVariable long id, @RequestBody RecipeDto recipeDto) {

        try {
            Recipe updatedRecipe = recipeService.updateRecipe(id, recipeDto.toRecipe());
            return ResponseEntity.ok(updatedRecipe);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRecipe(@PathVariable long id) {
        try {
            recipeService.deleteRecipe(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
