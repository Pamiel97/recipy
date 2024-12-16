package org.generation.italy.recipy.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "recipe_step")
public class RecipeStep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;
}
