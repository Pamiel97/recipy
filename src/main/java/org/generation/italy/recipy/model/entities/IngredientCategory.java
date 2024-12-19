package org.generation.italy.recipy.model.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ingredient_categories")
public class IngredientCategory {
    long id;
    String name;
    String description;

    @ManyToMany
    @JoinTable(
            name = "eating_regimes_ingredient_categories",
            joinColumns = @JoinColumn(name = "ingredient_categories_id"),
            inverseJoinColumns = @JoinColumn(name = "eating_regimes_id")
    )
    private List<EatingRegime> eatingRegimes = new ArrayList<>();

    
}
