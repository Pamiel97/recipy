package org.generation.italy.recipy.model.services.abstraction;

import org.generation.italy.recipy.model.entities.Pantry;
import org.generation.italy.recipy.model.exceptions.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

public interface PantryService {
    List<Pantry> findAllAvailableIngredients();
    Pantry savePantry(Pantry pantry, long userId, long ingredientId) throws EntityNotFoundException;
    Optional<Pantry> findPantryByIngredientId(long id);
    void delete(long id) throws EntityNotFoundException;

    List<Pantry> findPantriesByIngredientIdAndUserId(Long ingredientId, long userId);

    List<Pantry> findPantriesByUserId(long userId);
}
