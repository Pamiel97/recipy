package org.generation.italy.recipy.dtos;

import org.generation.italy.recipy.model.entities.Ingredient;
import org.generation.italy.recipy.model.entities.RecipeStep;

public class RecipeStepDto {
    private long id;
    private String description;
    private int ordinal;
    private String stepImgUrl;
    private long ingredientId;
    private long recipeId;

    public RecipeStepDto() {}

    public RecipeStepDto(long id, String description, int ordinal, String stepImgUrl, long ingredientId, long recipeId) {
        this.id = id;
        this.description = description;
        this.ordinal = ordinal;
        this.stepImgUrl = stepImgUrl;
        this.ingredientId = ingredientId;
        this.recipeId = recipeId;
    }

    public static RecipeStepDto fromRecipeStep(RecipeStep recipeStep){



        return new RecipeStepDto(recipeStep.getId(),recipeStep.getDescription(),
                                 recipeStep.getOrdinal(),recipeStep.getStepImgUrl(),recipeStep.getIngredient().getId(), recipeStep.getRecipe().getId());
    }

    //settare nel controller id per la ricetta
    public RecipeStep toRecipeStep(){
        RecipeStep recipeStep = new RecipeStep();
        recipeStep.setId(this.id);
        recipeStep.setDescription(this.description);
        recipeStep.setOrdinal(this.ordinal);
        recipeStep.setStepImgUrl(this.stepImgUrl);
        recipeStep.setIngredient(new Ingredient(this.ingredientId));
        return recipeStep;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(long recipeId) {
        this.recipeId = recipeId;
    }
}
