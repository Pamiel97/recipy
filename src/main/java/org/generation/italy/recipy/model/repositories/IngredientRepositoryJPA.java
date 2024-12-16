package org.generation.italy.recipy.model.repositories;

import org.generation.italy.recipy.model.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepositoryJPA extends JpaRepository<Ingredient, Long> {
}
