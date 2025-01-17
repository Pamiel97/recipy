package org.generation.italy.recipy.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "recipe_steps")
public class RecipeStep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;
    @ManyToOne
    @JoinColumn(name="ingredient_id")
    private Ingredient ingredient;
    private String description;
    private int ordinal;
    @Column(name="step_img_url")
    private String stepImgUrl;

    public RecipeStep() {}
    public RecipeStep(long id, Recipe recipe, Ingredient ingredient, String description, int ordinal, String stepImgUrl) {
        this.id = id;
        this.recipe = recipe;
        this.ingredient = ingredient;
        this.description = description;
        this.ordinal = ordinal;
        this.stepImgUrl = stepImgUrl;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Recipe getRecipe() {
        return recipe;
    }
    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
    public Ingredient getIngredient() {
        return ingredient;
    }
    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getOrdinal() {
        return ordinal;
    }
    public void setOrdinal(int ordinal) {
        this.ordinal = ordinal;
    }
    public String getStepImgUrl() {
        return stepImgUrl;
    }
    public void setStepImgUrl(String stepImgUrl) {
        this.stepImgUrl = stepImgUrl;
    }
}
