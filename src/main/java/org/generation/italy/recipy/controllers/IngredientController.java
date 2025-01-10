package org.generation.italy.recipy.controllers;

import org.generation.italy.recipy.dtos.IngredientDto;
import org.generation.italy.recipy.dtos.RecipeDto;
import org.generation.italy.recipy.model.entities.Ingredient;
import org.generation.italy.recipy.model.entities.Recipe;
import org.generation.italy.recipy.model.services.abstraction.IngredientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/ingredients")
public class IngredientController {

    private IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService){
        this.ingredientService = ingredientService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public ResponseEntity<List<IngredientDto>> getAllIngredients(){
        List<Ingredient> allIngredient = ingredientService.findAllIngredient()
                                                          .stream()
                                                          .sorted(Comparator.comparing(i -> i.getName()))
                                                          .toList();
        return ResponseEntity.ok(allIngredient.stream().map(IngredientDto::fromIngredient).toList());
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public ResponseEntity<IngredientDto> getIngredientById(@PathVariable Long id) {
        Optional<Ingredient> ingredientOptional = ingredientService.findById(id);
        if (ingredientOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Ingredient ingredient = ingredientOptional.get();
        IngredientDto ingredientDto = IngredientDto.fromIngredient(ingredient);
        return ResponseEntity.ok(ingredientDto);
    }

    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<Page<IngredientDto>> getPaginatedIngredients(@RequestParam (defaultValue = "1") int page,
                                                                       @RequestParam (defaultValue = "16") int size) {
        Page<Ingredient> allIngredients = ingredientService.findAllIngredientImpaginated(page, size);
        return ResponseEntity.ok(allIngredients.map(IngredientDto::fromIngredient));
    }
}
