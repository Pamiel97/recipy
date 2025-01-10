package org.generation.italy.recipy.model.repositories;

import org.generation.italy.recipy.model.entities.Ingredient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepositoryJPA extends JpaRepository<Ingredient, Long> {
    Page<Ingredient> findAll(Pageable pageable);
}
