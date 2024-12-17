package org.generation.italy.recipy.controllers;

import org.generation.italy.recipy.model.services.abstraction.IngredientService;
import org.generation.italy.recipy.model.services.abstraction.RecipeService;
import org.generation.italy.recipy.model.services.abstraction.RecipeStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/recipeStep")
public class RecipeStepController {
    private RecipeStepService recService;
    private IngredientService ingService;

    @Autowired
    public RecipeStepController(RecipeStepService recService, IngredientService ingService){
        this.recService=recService;
        this.ingService=ingService;
    }



}
