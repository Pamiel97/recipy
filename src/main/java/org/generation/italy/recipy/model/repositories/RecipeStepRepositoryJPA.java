package org.generation.italy.recipy.model.repositories;

import org.generation.italy.recipy.model.entities.RecipeStep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeStepRepositoryJPA extends JpaRepository<RecipeStep, Long> {
}
