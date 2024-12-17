package org.generation.italy.recipy.model.services.abstraction;

import org.generation.italy.recipy.model.entities.Ingredient;
import org.generation.italy.recipy.model.entities.Pantry;

import java.util.List;

public interface PantryService {
    List<Pantry> findAllAvailableIngredients();
}
