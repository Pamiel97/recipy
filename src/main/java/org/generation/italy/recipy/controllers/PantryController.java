package org.generation.italy.recipy.controllers;

import org.generation.italy.recipy.dtos.PantryDto;
import org.generation.italy.recipy.model.entities.Pantry;
import org.generation.italy.recipy.model.services.abstraction.PantryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/pantry")
public class PantryController {
    private PantryService pantryService;
    @Autowired
    public PantryController(PantryService pantryService) {
        this.pantryService = pantryService;
    }

    @GetMapping
    public ResponseEntity<List<PantryDto>> getAllPantries() {
        List<Pantry> pantries = pantryService.findAllAvailableIngredients();

        return ResponseEntity.ok(pantries.stream().map(PantryDto::fromPantry).toList());
    }
}
