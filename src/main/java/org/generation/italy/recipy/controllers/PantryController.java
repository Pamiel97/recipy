package org.generation.italy.recipy.controllers;

import org.generation.italy.recipy.dtos.PantryDto;
import org.generation.italy.recipy.model.entities.Ingredient;
import org.generation.italy.recipy.model.entities.Pantry;
import org.generation.italy.recipy.model.entities.User;
import org.generation.italy.recipy.model.exceptions.EntityNotFoundException;
import org.generation.italy.recipy.model.services.abstraction.IngredientService;
import org.generation.italy.recipy.model.services.abstraction.PantryService;
import org.generation.italy.recipy.model.services.abstraction.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/pantries")
public class PantryController {
    private PantryService pantryService;
    private IngredientService ingredientService;
    private UserService userService;

    @Autowired
    public PantryController(PantryService pantryService, IngredientService ingredientService, UserService userService) {
        this.pantryService = pantryService;
        this.ingredientService = ingredientService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> getAllPantries(@RequestParam (required = false) Long pantryId) {
        if(pantryId != null) {
            Optional<Pantry> optPantry = pantryService.findPantryById(pantryId);
            if(optPantry.isEmpty()){
                return ResponseEntity.badRequest().body(String.format("Pantry con id %d non trovato", pantryId));
            }
            return ResponseEntity.ok(PantryDto.fromPantry(optPantry.get()));
        } else {
            List<Pantry> pantries = pantryService.findAllAvailableIngredients();
            return ResponseEntity.ok(pantries.stream().map(PantryDto::fromPantry).toList());
        }
    }

    @PostMapping
    public ResponseEntity<?> createPantry(@RequestBody PantryDto pantryDto, @AuthenticationPrincipal User user, UriComponentsBuilder uriBuilder) {
        Optional<Ingredient> ingredient = ingredientService.findById(pantryDto.getIngredient());
        if (ingredient.isEmpty()) {
            return ResponseEntity.badRequest().body("ingrediente non trovato");
        }
        long userId = user.getId();
        try {
            Pantry pantry = pantryDto.toPantry();
            pantry.setIngredient(ingredient.get());
            Pantry createdPantry = pantryService.savePantry(pantry, userId);
            URI location = uriBuilder.path("/pantries/{id}").buildAndExpand(pantry.getId()).toUri();
            return ResponseEntity.created(location).body(PantryDto.fromPantry(createdPantry));
        } catch(EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePantry(@PathVariable long id, @RequestBody PantryDto pantryDto, @AuthenticationPrincipal User user) {
        if(id != pantryDto.getId()) {
            return ResponseEntity.badRequest().body("Gli id non coincidono");
        }
        Optional<Ingredient> ingredient = ingredientService.findById(pantryDto.getIngredient());
        if(ingredient.isEmpty()) {
            return ResponseEntity.badRequest().body("Ingrediente non trovato");
        }
        long userId = user.getId();

        try {
            Pantry pantry = pantryDto.toPantry();
            pantry.setIngredient(ingredient.get());
            Pantry updatedPantry = pantryService.savePantry(pantry, userId);
            return ResponseEntity.ok(PantryDto.fromPantry(updatedPantry));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePantry(@PathVariable long id) {
        Optional<Pantry> pantry = pantryService.findPantryById(id);
        if(pantry.isEmpty()) {
            return ResponseEntity.badRequest().body("Pantry non trovata");
        }
        try {
            pantryService.isDeleted(id);
            return ResponseEntity.ok(PantryDto.fromPantry(pantry.get()));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
