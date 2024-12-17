package org.generation.italy.recipy.dtos;

import org.generation.italy.recipy.model.entities.Category;
import org.generation.italy.recipy.model.entities.DietType;
import org.generation.italy.recipy.model.entities.Ingredient;
import org.generation.italy.recipy.model.entities.RecipeStep;

import java.util.List;

public class RecipeStepDto {
    private long id;
    private String description;
    private int ordinal;
    private String stepImgUrl;
    private String ingredientName;

    public RecipeStepDto() {}

    public RecipeStepDto(long id, String description, int ordinal, String stepImgUrl, String ingredientName) {
        this.id = id;
        this.description = description;
        this.ordinal = ordinal;
        this.stepImgUrl = stepImgUrl;
        this.ingredientName = ingredientName;
    }

    public static RecipeStepDto fromRecipeStep(RecipeStep recipeStep){

        return new RecipeStepDto(recipeStep.getId(),recipeStep.getDescription(),
                                 recipeStep.getOrdinal(),recipeStep.getStepImgUrl(),recipeStep.getIngredient().getName());
    }

    public RecipeStep toRecipeStep(){
        RecipeStep recipe = new RecipeStep();
        recipe.setId(this.id);
        recipe.setDescription(this.description);
        recipe.setOrdinal(this.ordinal);
        recipe.setStepImgUrl(this.stepImgUrl);
        //CREARE FINDBY NAME per settare gli ingredienti
//        Ingredient ingredient = findIngredientByName(this.ingredientName);
//        recipe.setIngredient(ingredient);
        return recipe;
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

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
}
