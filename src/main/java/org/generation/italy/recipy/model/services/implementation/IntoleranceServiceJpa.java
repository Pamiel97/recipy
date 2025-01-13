package org.generation.italy.recipy.model.services.implementation;

import org.generation.italy.recipy.model.entities.Intolerance;
import org.generation.italy.recipy.model.repositories.IngredientRepositoryJPA;
import org.generation.italy.recipy.model.repositories.IntoleranceRepositoryJpa;
import org.generation.italy.recipy.model.repositories.PantryRepositoryJPA;
import org.generation.italy.recipy.model.repositories.UserRepositoryJPA;
import org.generation.italy.recipy.model.services.abstraction.IntoleranceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IntoleranceServiceJpa implements IntoleranceService {

    private final IntoleranceRepositoryJpa intoleranceRepositoryJpa;

    public IntoleranceServiceJpa(IntoleranceRepositoryJpa intoleranceRepositoryJpa){
        this.intoleranceRepositoryJpa = intoleranceRepositoryJpa;
    }

    @Override
    public Optional<Intolerance> findIntoleranceById(long id) {
        return intoleranceRepositoryJpa.findById(id);
    }

    @Override
    public List<Intolerance> findAllIntolerances() {
        return intoleranceRepositoryJpa.findAll();
    }
}
