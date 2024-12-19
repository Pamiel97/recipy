package org.generation.italy.recipy.model.services.implementation;

import org.generation.italy.recipy.model.entities.RecipeStep;
import org.generation.italy.recipy.model.repositories.RecipeStepRepositoryJPA;
import org.generation.italy.recipy.model.services.abstraction.RecipeStepService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
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

    @Override
    public Optional<RecipeStep> updateRecipeStep(RecipeStep recipeStep) {
        Optional<RecipeStep> oR = repo.findById(recipeStep.getId());
        RecipeStep oldRecipeStep = null;
        if(oR.isPresent()){
            oldRecipeStep = new RecipeStep(oR.get().getId(),oR.get().getRecipe(), oR.get().getIngredient(), oR.get().getDescription(), oR.get().getOrdinal(), oR.get().getStepImgUrl());
            repo.save(recipeStep);
        }
        return Optional.ofNullable(oldRecipeStep);
    }
}
