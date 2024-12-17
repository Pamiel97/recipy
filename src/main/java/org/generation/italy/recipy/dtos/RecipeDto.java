package org.generation.italy.recipy.dtos;

import org.generation.italy.recipy.model.entities.Recipe;
import org.generation.italy.recipy.model.entities.RecipeStep;
import org.generation.italy.recipy.model.entities.Tag;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RecipeDto {
    private long id;
    private String title;
    private String description;
    private String difficulty;
    private double kCalories;
    private String creationDate;
    private String imgUrl;
    private UserDto user;
    private List<String> tags;
    private List<RecipeStepDto> recipeSteps;

    public RecipeDto() {}

    public RecipeDto(long id, String title, String description, String difficulty, double kCalories, String creationDate,
                     String imgUrl, UserDto user, List<String> tags, List<RecipeStepDto> recipeSteps) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.difficulty = difficulty;
        this.kCalories = kCalories;
        this.creationDate = creationDate;
        this.imgUrl = imgUrl;
        this.user = user;
        this.tags = tags;
        this.recipeSteps = recipeSteps;
    }


    //TODO
    public static RecipeDto fromRecipe(Recipe recipe) {
        List<String> tagNames = new ArrayList<>();
        if (recipe.getTag() != null) {
            for (Tag tag : recipe.getTag()) {
                tagNames.add(tag.getName());
            }
        }

        List<RecipeStepDto> recipeStepDtos = new ArrayList<>();
        if (recipe.getRecipeSteps() != null) {
            for (RecipeStep recipeStep : recipe.getRecipeSteps()) {
                recipeStepDtos.add(RecipeStepDto.fromRecipeStep(recipeStep));
            }
        }

        String creationDateString = null;
        if (recipe.getCreationDate() != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
            creationDateString = recipe.getCreationDate().format(formatter);
        }

       // UserDto userDto = UserDto.fromUser(recipe.getUser());

//        return new RecipeDto(
//                recipe.getId(),
//                recipe.getTitle(),
//                recipe.getDescription(),
//                recipe.getDifficulty(),
//                recipe.getkCalories(),
//                creationDateString,
//                recipe.getImgUrl(),
//                //userDto,
//                tagNames,
//                recipeStepDtos
//        );
        return null;
    }

}
