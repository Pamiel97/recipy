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
            WHERE NOT EXISTS (
                SELECT rs
                FROM RecipeStep rs
                WHERE rs.recipe = r
                AND rs.ingredient.ingredientCategory NOT IN (
                    SELECT ic
                    FROM User u
                    JOIN u.eatingRegime er
                    JOIN er.ingredientCategories ic
                    WHERE u.id = :userId
                )
            )
            """)
    List<Recipe> recipesOkToUserDietType(@Param("userId") long userId);

    @Query("""
            SELECT r
            FROM Recipe r
            WHERE NOT EXISTS (
                SELECT rs
                FROM RecipeStep rs
                WHERE rs.recipe = r
                AND rs.ingredient.intolerance NOT IN (
                    SELECT intolerances
                    FROM User u
                    WHERE u.id = :userId
                )
            )
            """)
    List<Recipe> recipesOkToUserIntolerancesAndAllergies(@Param("userId") long userId); //TODO non funziona porcodio

//    List<Recipe> recipesOkToUser(@Param("userId") long userId); //TODO

    @Query("""
            SELECT r
            FROM Recipe r
            JOIN User u ON r.user.id = u.id
            WHERE u.id = :userId
            AND (
                (u.profile = 'chef' AND r.difficulty = 'difficile')
                OR (u.profile = 'dietologo' AND r.difficulty IN ('medio', 'facile'))
                OR (u.profile = 'altro' AND r.difficulty IN ('medio', 'facile'))
                OR (u.profile = 'utente_base' AND r.difficulty = 'facile')
            )
            """)
    List<Recipe> findRecipesForUserProfile(@Param("userId") long userId);

    @Query("""
            SELECT r
            FROM Recipe r
            WHERE (r.prepTime + r.cookingTime) < :minutes
            """)
    List<Recipe> findAllRecipesShorterThan(@Param("minutes") int minutes);


//    @Query("""
//            SELECT r
//            FROM Recipe r
//            JOIN RecipeStep rs ON r.id = rs.recipe.id
//            JOIN Pantry p ON rs.ingredient.id = p.ingredient.id
//            JOIN User u ON p.user.id = u.id
//            WHERE u.id = :userId
//
//            AND rs.ingredient.id =
//            (SELECT rs2.ingredient.id
//            FROM RecipeStep rs2
//            WHERE rs2.recipe.id = r.id)
//
//            AND p.ingredient.id =
//            (SELECT p2.ingredient.id
//            FROM Pantry p2
//            JOIN User u2 ON p2.user.id = u2.id
//            WHERE u2.id = :userId)
//
//            AND rs.ingredient.id IN (p.ingredient.id)
//            """)

    @Query("""
            SELECT r
            FROM Recipe r
            WHERE NOT EXISTS
            ( SELECT rs
            FROM RecipeStep rs
            WHERE rs.recipe = r
            AND rs.ingredient NOT IN
            ( SELECT p.ingredient
            FROM Pantry p
            WHERE p.user.id = :userId ) )
            """)
    List<Recipe> findByAvailablePantry(@Param("userId") long userId);
}
