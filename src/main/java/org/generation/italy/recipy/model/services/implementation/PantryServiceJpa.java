package org.generation.italy.recipy.model.services.implementation;

import org.generation.italy.recipy.model.entities.Ingredient;
import org.generation.italy.recipy.model.entities.Pantry;
import org.generation.italy.recipy.model.entities.User;
import org.generation.italy.recipy.model.exceptions.EntityNotFoundException;
import org.generation.italy.recipy.model.repositories.IngredientRepositoryJPA;
import org.generation.italy.recipy.model.repositories.PantryRepositoryJPA;
import org.generation.italy.recipy.model.repositories.UserRepositoryJPA;
import org.generation.italy.recipy.model.services.abstraction.PantryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class PantryServiceJpa implements PantryService {
    private PantryRepositoryJPA pantryRepo;
    private UserRepositoryJPA userRepo;
    private IngredientRepositoryJPA ingredientRepo;

    public PantryServiceJpa(PantryRepositoryJPA pantryRepo, UserRepositoryJPA userRepo, IngredientRepositoryJPA ingredientRepo){
        this.pantryRepo = pantryRepo;
        this.userRepo = userRepo;
        this.ingredientRepo = ingredientRepo;
    }
    @Override
    public List<Pantry> findAllAvailableIngredients() {
        return pantryRepo.findAll();
    }

    @Override
    public Pantry savePantry(Pantry pantry, long userId, long ingredientId) throws EntityNotFoundException {
        Optional<Ingredient> ingredient = ingredientRepo.findById(ingredientId);
        if (ingredient.isEmpty()) {
            throw new EntityNotFoundException(String.format("Ingrediente con id %d non trovato!", ingredientId));
        }
        pantry.setIngredient(ingredient.get());
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
    public void delete(long id) throws EntityNotFoundException {
        Optional<Pantry> optPantry = findPantryById(id);
        if(optPantry.isEmpty()) {
            throw new EntityNotFoundException(String.format("Pantry con id %d non trovata!", id));
        }
        pantryRepo.deleteById(id);
    }

    @Override
    public List<Pantry> findPantriesByIngredientIdAndUserId(Long ingredientId, long userId) {
        return pantryRepo.findByIngredientIdAndUserId(ingredientId, userId);
    }

    @Override
    public List<Pantry> findPantriesByUserId(long userId) {
        return pantryRepo.findByUserId(userId);
    }

    @Override
    public Pantry findPantryByIdAndUserId(Long pantryId, long userId) {
//        Optional<Pantry> pantry = pantryRepo.findById(pantryId);
//        if (pantry.isEmpty()) {
//            throw new EntityNotFoundException(String.format("Pantry con id %d non trovata", pantryId);
//        }
//
//        Optional<User> ou = userRepo.findById(userId);
//        if(ou.isEmpty()){
//            throw new EntityNotFoundException(String.format("Utente con id %d non trovato!", userId));
//        }
//        pantry.get().setUser(ou.get());
//
//        return pantryRepo.save(pantry.get());

        return pantryRepo.findByIdAndUserId(pantryId, userId);
    }

    @Override
    public Page<Pantry> findPaginatedUserPantries(int page, int size, long userId) throws EntityNotFoundException {
        Optional<User> optionalUser = userRepo.findById(userId);
        if(optionalUser.isEmpty()) {
            throw new EntityNotFoundException(String.format("Utente con id %d non trovato!", userId));
        }
        Pageable pageable = PageRequest.of(page, size);
        return pantryRepo.findUserPantries(pageable, userId);
    }

}
