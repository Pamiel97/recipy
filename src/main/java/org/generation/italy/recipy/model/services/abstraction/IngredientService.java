package org.generation.italy.recipy.model.services.abstraction;

import org.generation.italy.recipy.model.entities.Ingredient;

import java.util.Optional;

public interface IngredientService {
    //gestisce calcolo delle calorie
    Optional<Ingredient> findById(long id);
    //Optional<Ingredient> findByName(String name);
}
