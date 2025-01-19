package org.generation.italy.recipy.model.repositories;

import org.generation.italy.recipy.model.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepositoryJPA extends JpaRepository<Review, Long> {

    @Query("SELECT r FROM Review r " +
            "WHERE r.recipe.id = :recipeId " +
            "ORDER BY " +
            "    CASE " +
            "        WHEN r.user.id = :idUtente THEN 0 " +
            "        ELSE 1 " +
            "    END, " +
            "    r.creationDate DESC")
    List<Review> findAllByRecipeId(@Param("idUtente") Long idUtente, @Param("recipeId") Long recipeId);

}
