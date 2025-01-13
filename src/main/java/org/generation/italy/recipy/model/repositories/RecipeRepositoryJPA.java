package org.generation.italy.recipy.model.repositories;


import org.generation.italy.recipy.model.entities.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeRepositoryJPA extends JpaRepository<Recipe, Long> {
    List<Recipe> findByUserId(long userId);
    List<Recipe> findByUserEmail(String email);
    @Query("SELECT r FROM Recipe r WHERE LOWER(r.title) LIKE LOWER(CONCAT('%', :title, '%'))")
    List<Recipe> findByTitleContaining(@Param("title") String title);


    Page<Recipe> findAll(Pageable pageable);

    @Query("Select r From Recipe r WHERE r.user.id = :userId")
    Page<Recipe> findUserRecipes(Pageable pageable, @Param("userId") long userId);
}
