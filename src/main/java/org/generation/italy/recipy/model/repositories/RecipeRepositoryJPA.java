package org.generation.italy.recipy.model.repositories;

import org.generation.italy.recipy.model.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepositoryJPA extends JpaRepository<Recipe, Long> {
}
