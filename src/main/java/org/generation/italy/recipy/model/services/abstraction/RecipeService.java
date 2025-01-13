package org.generation.italy.recipy.model.services.abstraction;

import org.generation.italy.recipy.model.entities.Recipe;
import org.generation.italy.recipy.model.exceptions.EntityNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface RecipeService {
    Recipe createRecipe(Recipe recipe, long userId) throws EntityNotFoundException;
    Optional<Recipe> findById(long id);
    List<Recipe> findAll();
    Recipe updateRecipe(long id, Recipe updatedRecipe) throws EntityNotFoundException;
    void deleteRecipe(long id) throws EntityNotFoundException;
    List<Recipe> findAllByUserId(long userId);
    List<Recipe> findByUserEmail(String email);
    List<Recipe> findByTitleContainingIgnoreCase(String title);
    Page<Recipe> getRecipes(int page, int size);
    Page<Recipe> getUserImpaginatedRecipes(int page, int size, long userId) throws EntityNotFoundException;

}
