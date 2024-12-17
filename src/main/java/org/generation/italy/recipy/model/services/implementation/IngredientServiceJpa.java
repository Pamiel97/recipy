package org.generation.italy.recipy.model.services.implementation;

import org.generation.italy.recipy.model.entities.Allergy;
import org.generation.italy.recipy.model.entities.Ingredient;
import org.generation.italy.recipy.model.entities.Intolerance;
import org.generation.italy.recipy.model.repositories.AllergyRepositoryJpa;
import org.generation.italy.recipy.model.repositories.IngredientRepositoryJPA;
import org.generation.italy.recipy.model.repositories.IntoleranceRepositoryJpa;
import org.generation.italy.recipy.model.services.abstraction.IngredientService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IngredientServiceJpa implements IngredientService {
    private IngredientRepositoryJPA repo;
    private IntoleranceRepositoryJpa intoRepo;
    private AllergyRepositoryJpa allergyRepo;

    public IngredientServiceJpa(IngredientRepositoryJPA repo, IntoleranceRepositoryJpa intoRepo, AllergyRepositoryJpa allergyRepo ){
        this.repo=repo;
    }

    @Override
    public Optional<Ingredient> findById(long id) {
        return repo.findById(id);
    }

    @Override
    public Optional<Allergy> findAllergyById(long id) {
        return allergyRepo.findById(id);
    }

    @Override
    public Optional<Intolerance> findIntoleranceById(long id) {
        return intoRepo.findById(id);
    }


}
