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
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.swing.text.html.parser.Entity;
import java.net.URI;
import java.security.Principal;
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
    public ResponseEntity<List<PantryDto>> getAllPantries() {
        List<Pantry> pantries = pantryService.findAllAvailableIngredients();
        return ResponseEntity.ok(pantries.stream().map(PantryDto::fromPantry).toList());
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
            Pantry createdPantry = pantryService.createPantry(pantry, userId);
            URI location = uriBuilder.path("/pantries/{id}").buildAndExpand(pantry.getId()).toUri();
            return ResponseEntity.created(location).body(PantryDto.fromPantry(createdPantry));
        } catch(EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
