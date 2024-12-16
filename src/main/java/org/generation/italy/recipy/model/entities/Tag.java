package org.generation.italy.recipy.model.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Tag {
    long id;
    String name;

    @ManyToMany
    @JoinTable(name="recipe_tag", joinColumns = @JoinColumn(name="recipe_id"),
    inverseJoinColumns = @JoinColumn(name="tag_id"))
    List<Recipe> recipes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
}
