package org.generation.italy.recipy.model.repositories;


import org.generation.italy.recipy.model.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeRepositoryJPA extends JpaRepository<Recipe, Long> {
    List<Recipe> findByUserId(long userId);
}
