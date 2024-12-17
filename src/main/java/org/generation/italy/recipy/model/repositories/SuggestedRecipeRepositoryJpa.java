package org.generation.italy.recipy.model.repositories;

import org.generation.italy.recipy.model.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SuggestedRecipeRepositoryJpa extends JpaRepository<Recipe, Long> {
    @Query("""
            SELECT r
            FROM Recipes r
            JOIN RecipeSteps rs ON r.id = rs.recipe.id
            JOIN Ingredients i ON rs.ingredient.id = i.id
            JOIN Users u ON r.user.id = u.id
            WHERE u.id = :userId
            AND i.dietCompatibility = u.dietType
            GROUP BY r.id
            HAVING COUNT(i.id) = (
                SELECT COUNT(rs2.id)
                FROM RecipeSteps rs2
                JOIN Ingredients i2 ON rs2.ingredient.id = i2.id
                WHERE rs2.recipe.id = r.id
            )
            """)
    List<Recipe> recipesOkToUserDietType(@Param("userId") long userId);
}
