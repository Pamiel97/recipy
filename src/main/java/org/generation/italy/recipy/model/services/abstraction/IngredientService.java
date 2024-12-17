package org.generation.italy.recipy.model.services.abstraction;

import org.generation.italy.recipy.model.entities.Allergy;
import org.generation.italy.recipy.model.entities.Ingredient;
import org.generation.italy.recipy.model.entities.Intolerance;

import java.util.Optional;

public interface IngredientService {
    //gestisce calcolo delle calorie
    Optional<Ingredient> findById(long id);
    //Optional<Ingredient> findByName(String name);
    Optional<Allergy> findAllergyById(long id);
    Optional<Intolerance> findIntoleranceById(long id);

}
