package org.generation.italy.recipy.model.services.implementation;

import org.generation.italy.recipy.model.entities.RecipeStep;
import org.generation.italy.recipy.model.repositories.RecipeStepRepositoryJPA;
import org.generation.italy.recipy.model.services.abstraction.RecipeStepService;

import java.util.Optional;

public class RecipeStepServiceJpa implements RecipeStepService {

    private RecipeStepRepositoryJPA repo;

    public RecipeStepServiceJpa(RecipeStepRepositoryJPA repo){
        this.repo=repo;
    }

    @Override
    public RecipeStep createRecipeStep(RecipeStep recipeStep) {
        return repo.save(recipeStep);
    }

    @Override
    public Optional<RecipeStep> findById(long id) {
        return repo.findById(id);
    }
}
