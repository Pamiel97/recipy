package org.generation.italy.recipy.controllers;

import org.generation.italy.recipy.dtos.IngredientDto;
import org.generation.italy.recipy.dtos.RecipeDto;
import org.generation.italy.recipy.model.entities.Ingredient;
import org.generation.italy.recipy.model.entities.Recipe;
import org.generation.italy.recipy.model.services.abstraction.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/ingredients")
public class IngredientController {

    private IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService){
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public ResponseEntity<List<IngredientDto>> getAllIngredients(){
        List<Ingredient> allIngredient = ingredientService.findAllIngredient();
        return ResponseEntity.ok(allIngredient.stream().map(IngredientDto::fromIngredient).toList());
    }

}
