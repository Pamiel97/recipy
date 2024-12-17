package org.generation.italy.recipy.controllers;

import org.generation.italy.recipy.model.entities.Recipe;
import org.generation.italy.recipy.model.services.abstraction.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    //recupero tutto le richieste GET
    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    //recupero una ricetta per ID GET
    @GetMapping("/{id}")
    public Recipe getRecipeById(long id) {
        return recipeService.findById(id).orElse(null);
    }

    //creo una ricetta POST
    @GetMapping("/create")
    public Recipe createRecipe(Recipe recipe) {
        return recipeService.createRecipe(recipe);
    }

    //aggiorno una ricetta PUT
    @GetMapping("/update")
    public boolean updateRecipe(Recipe recipe) {
        return recipeService.updateRecipe(recipe);
    }

    //elimino una ricetta
    @GetMapping("/delete/{id}")
    public boolean deleteRecipeById(long id) {
        return recipeService.deleteRecipeById(id);
    }
}
