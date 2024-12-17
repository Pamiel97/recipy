package org.generation.italy.recipy.model.repositories;

import org.generation.italy.recipy.model.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SuggestedRecipeRepositoryJpa extends JpaRepository<Recipe, Long> {
    @Query("""
            SELECT r
            FROM Recipe r
            JOIN RecipeStep rs ON r.id = rs.recipe.id
            JOIN Ingredient i ON rs.ingredient.id = i.id
            JOIN User u ON r.user.id = u.id
            WHERE u.id = :userId
            AND i.dietCompatibility = u.dietType
            GROUP BY r.id
            HAVING COUNT(i.id) = (
                SELECT COUNT(rs2.id)
                FROM RecipeStep rs2
                JOIN Ingredient i2 ON rs2.ingredient.id = i2.id
                WHERE rs2.recipe.id = r.id
            )
            """)
    List<Recipe> recipesOkToUserDietType(@Param("userId") long userId);
}
