package org.generation.italy.recipy.model.services.abstraction;

import org.generation.italy.recipy.dtos.PantryDto;
import org.generation.italy.recipy.model.entities.Ingredient;
import org.generation.italy.recipy.model.entities.Pantry;
import org.generation.italy.recipy.model.exceptions.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

public interface PantryService {
    List<Pantry> findAllAvailableIngredients();
    Pantry savePantry(Pantry pantry, long userId) throws EntityNotFoundException;
    Optional<Pantry> findPantryById(long id);
    void isDeleted(long id) throws EntityNotFoundException;
}
