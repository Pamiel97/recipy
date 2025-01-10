package org.generation.italy.recipy.model.services.abstraction;

import org.generation.italy.recipy.model.entities.Allergy;
import org.generation.italy.recipy.model.entities.Ingredient;
import org.generation.italy.recipy.model.entities.Intolerance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IngredientService {
    //gestisce calcolo delle calorie
    Optional<Ingredient> findById(long id);
    Optional<Allergy> findAllergyById(long id);
    Optional<Intolerance> findIntoleranceById(long id);
    List<Ingredient> findAllIngredient();
    Page<Ingredient> findAllIngredientImpaginated(int page, int size);
}
