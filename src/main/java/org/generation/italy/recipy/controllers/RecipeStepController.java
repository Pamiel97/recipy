package org.generation.italy.recipy.controllers;

import org.generation.italy.recipy.dtos.RecipeStepDto;
import org.generation.italy.recipy.model.entities.Recipe;
import org.generation.italy.recipy.model.entities.RecipeStep;
import org.generation.italy.recipy.model.services.abstraction.IngredientService;
import org.generation.italy.recipy.model.services.abstraction.RecipeService;
import org.generation.italy.recipy.model.services.abstraction.RecipeStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/recipeSteps")
public class RecipeStepController {
    private RecipeStepService recipeStepService;
    private IngredientService ingService;
    private RecipeService recipeService;


    @Autowired
    public RecipeStepController(RecipeStepService recService, IngredientService ingService, RecipeService recipeService){
        this.recipeStepService =recService;
        this.ingService=ingService;
        this.recipeService=recipeService;
    }


    @PostMapping
    public ResponseEntity<?> createRecipe(@RequestBody RecipeStepDto stepDto){
        Optional<Recipe> optionalRecipe = recipeService.findById(stepDto.getRecipeId());

        if (optionalRecipe.isEmpty()) {
            return ResponseEntity.status(404).body("Ricetta non trovata");
        }
        RecipeStep recipeStep = stepDto.toRecipeStep();
        recipeStep.setRecipe(optionalRecipe.get());
        RecipeStep savedStep = recipeStepService.createRecipeStep(recipeStep);
        return ResponseEntity.ok(savedStep);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@RequestBody RecipeStepDto dto, @PathVariable long id) {
        if (id != dto.getId()) {
            return ResponseEntity.badRequest().body("Gli id della richiesta e del body non coincidono");
        }
        RecipeStep recipeStep = dto.toRecipeStep();
        Optional<RecipeStep> updatedStep = recipeStepService.updateRecipeStep(recipeStep);
        if (updatedStep.isPresent()) {
            return ResponseEntity.ok(updatedStep.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
