package org.generation.italy.recipy.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "recipe_steps")
public class RecipeStep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
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

    private double quantity; //quantità dell'ingrediente
    private String unit; //unità dell'ingrediente

    public RecipeStep(double quantity, String unit) {
        this.quantity = quantity;
        this.unit = unit;
    }
    public RecipeStep(long id, Recipe recipe, Ingredient ingredient, String description, int ordinal, String stepImgUrl, double quantity, String unit) {
        this.id = id;
        this.recipe = recipe;
        this.ingredient = ingredient;
        this.description = description;
        this.ordinal = ordinal;
        this.stepImgUrl = stepImgUrl;
        this.quantity = quantity;
        this.unit = unit;
    }

    public RecipeStep() {}

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

    public double getQuantity() {return quantity;}

    public void setQuantity(double quantity) {this.quantity = quantity;}

    public String getUnit() {return unit;}

    public void setUnit(String unit) {this.unit = unit;}
}
