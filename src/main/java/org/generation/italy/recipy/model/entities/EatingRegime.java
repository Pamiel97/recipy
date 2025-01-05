package org.generation.italy.recipy.model.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "eating_regimes")
public class EatingRegime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    @ManyToMany(mappedBy = "eatingRegimes")
    private List<IngredientCategory> ingredientCategories = new ArrayList<>();

    public EatingRegime(){}
    public EatingRegime(long id, String name, String description, List<User> user,
                        List<IngredientCategory> ingredientCategories) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ingredientCategories = ingredientCategories;
    }

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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<IngredientCategory> getIngredientCategories() {
        return ingredientCategories;
    }
    public void setIngredientCategories(List<IngredientCategory> ingredientCategories) {
        this.ingredientCategories = ingredientCategories;
    }
}
