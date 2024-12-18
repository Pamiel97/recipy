package org.generation.italy.recipy.model.services.implementation;

import org.generation.italy.recipy.dtos.PantryDto;
import org.generation.italy.recipy.model.entities.Ingredient;
import org.generation.italy.recipy.model.entities.Pantry;
import org.generation.italy.recipy.model.entities.User;
import org.generation.italy.recipy.model.exceptions.EntityNotFoundException;
import org.generation.italy.recipy.model.repositories.PantryRepositoryJPA;
import org.generation.italy.recipy.model.repositories.UserRepositoryJPA;
import org.generation.italy.recipy.model.services.abstraction.PantryService;
import org.generation.italy.recipy.model.services.abstraction.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PantryServiceJpa implements PantryService {
    private PantryRepositoryJPA pantryRepo;
    private UserRepositoryJPA userRepo;

    public PantryServiceJpa(PantryRepositoryJPA pantryRepo, UserRepositoryJPA userRepo){
        this.pantryRepo = pantryRepo;
        this.userRepo = userRepo;
    }
    @Override
    public List<Pantry> findAllAvailableIngredients() {
        return pantryRepo.findAll();
    }

    @Override
    public Pantry savePantry(Pantry pantry, long userId) throws EntityNotFoundException {
        Optional<User> ou = userRepo.findById(userId);
        if(ou.isEmpty()){
            throw new EntityNotFoundException(String.format("Utente con id %d non trovato!", userId));
        }
        pantry.setUser(ou.get());
        return pantryRepo.save(pantry);
    }

    @Override
    public Optional<Pantry> findPantryById(long id) {
        return pantryRepo.findById(id);
    }

    @Override
    public void isDeleted(long id) throws EntityNotFoundException {
        Optional<Pantry> optPantry = findPantryById(id);
        if(optPantry.isEmpty()) {
            throw new EntityNotFoundException(String.format("Pantry con id %d non trovata!", id));
        }
        pantryRepo.deleteById(id);
    }
}
