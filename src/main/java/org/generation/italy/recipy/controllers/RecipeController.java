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
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
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

    @CrossOrigin(origins = "http://localhost:4200")
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
        if(id != recipeDto.getId()) {
            return ResponseEntity.badRequest().body("Gli id non coincidono");
        }
        try {
            Recipe updatedRecipe = recipeService.updateRecipe(id, recipeDto.toRecipe());
            RecipeDto updatedRecipeDto = RecipeDto.fromRecipe(updatedRecipe);
            return ResponseEntity.ok(updatedRecipeDto);
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

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RecipeDto>> getRecipesByUserId(@PathVariable long userId) {
        try {
            List<Recipe> recipes = recipeService.findAllByUserId(userId);
            if (recipes.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(recipes.stream().map(RecipeDto::fromRecipe).toList());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/user/email/{email}")
    public ResponseEntity<List<RecipeDto>> getRecipesByUserEmail(@PathVariable String email) {
        try {
            List<Recipe> recipes = recipeService.findByUserEmail(email);
            if (recipes.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(recipes.stream().map(RecipeDto::fromRecipe).toList());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeDto> getRecipeById(@PathVariable long id) {
        try {
            Recipe recipe = recipeService.findById(id).orElseThrow(() -> new EntityNotFoundException("Ricetta non trovata"));
            RecipeDto recipeDto = RecipeDto.fromRecipe(recipe);
            return ResponseEntity.ok(recipeDto);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("search/{title}")
    public ResponseEntity<?> getRecipeByTitle(@PathVariable String title) {
        try {
            List<Recipe> recipes = recipeService.findByTitleContainingIgnoreCase(title);
            if (recipes.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(recipes.stream().map(RecipeDto::fromRecipe).toList());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore interno del server");
        }
    }


    @GetMapping("/user/recipes")
    public ResponseEntity<List<RecipeDto>> getRecipesByAuthenticatedUser(@AuthenticationPrincipal User user) {
        try {
            if (user == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
            long userId = user.getId();
            List<Recipe> recipes = recipeService.findAllByUserId(userId);
            if (recipes.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            List<RecipeDto> recipeDtos = recipes.stream()
                    .map(RecipeDto::fromRecipe)
                    .toList();
            return ResponseEntity.ok(recipeDtos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }



    @GetMapping("/banana")
    public ResponseEntity<Page<RecipeDto>> getRecipes(@RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "8") int size) {
        Page<RecipeDto> recipesPage = recipeService.getRecipes(page, size).map(RecipeDto::fromRecipe);
        return ResponseEntity.ok(recipesPage);
    }
    @GetMapping("user.s")
    public ResponseEntity<Page<RecipeDto>> getPaginatedUserRecipes(@RequestParam(defaultValue = "1") int page,
                                                                   @RequestParam(defaultValue = "8") int size,
                                                                   @AuthenticationPrincipal User user) {
        try {
            Page<RecipeDto> userPagedRecipes = recipeService.getUserImpaginatedRecipes(page, size, user.getId()).map(RecipeDto::fromRecipe);
            return ResponseEntity.ok(userPagedRecipes);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
