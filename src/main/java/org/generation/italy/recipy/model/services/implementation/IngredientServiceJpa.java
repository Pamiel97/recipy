package org.generation.italy.recipy.model.services.implementation;

import org.generation.italy.recipy.model.entities.Ingredient;
import org.generation.italy.recipy.model.repositories.IngredientRepositoryJPA;
import org.generation.italy.recipy.model.services.abstraction.IngredientService;

import java.util.Optional;

public class IngredientServiceJpa implements IngredientService {
    private IngredientRepositoryJPA repo;

    public IngredientServiceJpa(IngredientRepositoryJPA repo){
        this.repo=repo;
    }

    @Override
    public Optional<Ingredient> findById(long id) {
        return repo.findById(id);
    }


}
