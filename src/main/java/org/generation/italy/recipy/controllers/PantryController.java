package org.generation.italy.recipy.controllers;

import org.generation.italy.recipy.dtos.PantryDto;
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

    @CrossOrigin
    @GetMapping
    public ResponseEntity<?> getAllPantries(@RequestParam (required = false) Long ingredientId, @AuthenticationPrincipal User user) {
        List<Pantry> pantries = null;
        if(ingredientId != null) {
            pantries = pantryService.findPantriesByIngredientIdAndUserId(ingredientId, user.getId());
        } else {
            pantries = pantryService.findPantriesByUserId(user.getId());
        }
        return ResponseEntity.ok(pantries.stream().map(PantryDto::fromPantry).toList());

    }
    @CrossOrigin
    @PostMapping
    public ResponseEntity<?> createPantry(@RequestBody PantryDto pantryDto, @AuthenticationPrincipal User user, UriComponentsBuilder uriBuilder) {
        long userId = user.getId();
        try {
            Pantry pantry = pantryDto.toPantry();
            Pantry createdPantry = pantryService.savePantry(pantry, userId, pantryDto.getIngredientId());
            URI location = uriBuilder.path("/pantries/{id}").buildAndExpand(pantry.getId()).toUri();
            return ResponseEntity.created(location).body(PantryDto.fromPantry(createdPantry));
        } catch(EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePantry(@PathVariable long id, @RequestBody PantryDto pantryDto, @AuthenticationPrincipal User user) {
        if(id != pantryDto.getId()) {
            return ResponseEntity.badRequest().body("Gli id non coincidono");
        }
        long userId = user.getId();
        try {
            Pantry pantry = pantryDto.toPantry();
            Pantry updatedPantry = pantryService.savePantry(pantry, userId, pantryDto.getIngredientId());
            return ResponseEntity.ok(PantryDto.fromPantry(updatedPantry));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePantry(@PathVariable long id) {
        Optional<Pantry> pantry = pantryService.findPantryByIngredientId(id);
        if(pantry.isEmpty()) {
            return ResponseEntity.badRequest().body("Pantry non trovata");
        }
        try {
            pantryService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
