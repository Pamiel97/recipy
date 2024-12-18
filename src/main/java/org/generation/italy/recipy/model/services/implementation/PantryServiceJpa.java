package org.generation.italy.recipy.model.services.implementation;

import org.generation.italy.recipy.model.entities.Ingredient;
import org.generation.italy.recipy.model.entities.Pantry;
import org.generation.italy.recipy.model.repositories.PantryRepositoryJPA;
import org.generation.italy.recipy.model.services.abstraction.PantryService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PantryServiceJpa implements PantryService {
    PantryRepositoryJPA pantryRepo;

    public PantryServiceJpa(PantryRepositoryJPA pantryRepo){
        this.pantryRepo = pantryRepo;
    }
    @Override
    public List<Pantry> findAllAvailableIngredients() {
        return pantryRepo.findAll();
    }
}
