package org.generation.italy.recipy.model.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ingredient_categories")
public class IngredientCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "ingredientCategory")
    private List<Ingredient> ingredients;
    @ManyToMany
    @JoinTable(
            name = "eating_regimes_ingredient_categories",
            joinColumns = @JoinColumn(name = "ingredient_categories_id"),
            inverseJoinColumns = @JoinColumn(name = "eating_regimes_id")
    )
    private List<EatingRegime> eatingRegimes = new ArrayList<>();

    public IngredientCategory(){}
    public IngredientCategory(long id, String name, String description, List<Ingredient> ingredients,
                              List<EatingRegime> eatingRegimes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.eatingRegimes = eatingRegimes;
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
    public List<Ingredient> getIngredients() {
        return ingredients;
    }
    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
    public List<EatingRegime> getEatingRegimes() {
        return eatingRegimes;
    }
    public void setEatingRegimes(List<EatingRegime> eatingRegimes) {
        this.eatingRegimes = eatingRegimes;
    }
}
