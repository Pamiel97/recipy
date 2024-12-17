package org.generation.italy.recipy.dtos;

import org.generation.italy.recipy.model.entities.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RecipeDto {
    private long id;
    private String title;
    private String description;
    private String course;
    private int prepTime;
    private int cookingTime;
    private String difficulty;
    private double kCalories;
    private String creationDate;
    private String imgUrl;
    private UserDto user;
    private List<String> tags;
    private List<RecipeStepDto> recipeSteps;

    public RecipeDto() {}

    public RecipeDto(long id, String title, String description,String category, int prepTime, int cookingTime, String difficulty, double kCalories, String creationDate,
                     String imgUrl, UserDto user, List<String> tags, List<RecipeStepDto> recipeSteps) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.course = category;
        this.prepTime = prepTime;
        this.cookingTime = cookingTime;
        this.difficulty = difficulty;
        this.kCalories = kCalories;
        this.creationDate = creationDate;
        this.imgUrl = imgUrl;
        this.user = user;
        this.tags = tags;
        this.recipeSteps = recipeSteps;
    }



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

        UserDto userDto = UserDto.fromUser(recipe.getUser());



        return new RecipeDto(
                recipe.getId(),
                recipe.getTitle(),
                recipe.getDescription(),
                recipe.getCourse().toString(),
                recipe.getPrepTime(),
                recipe.getCookingTime(),
                recipe.getDifficulty(),
                recipe.getkCalories(),
                creationDateString,
                recipe.getImgUrl(),
                userDto,
                tagNames,
                recipeStepDtos
        );
    }

    //SETTARE ID USER
    public Recipe toRecipe(){
        Recipe recipe = new Recipe();
        recipe.setId(this.id);
        recipe.setTitle(this.title);
        recipe.setDescription(this.description);
        recipe.setCourse(Course.valueOf(this.course));
        recipe.setPrepTime(this.prepTime);
        recipe.setPrepTime(this.cookingTime);
        recipe.setDifficulty(this.difficulty);
        recipe.setkCalories(this.kCalories);

        if (this.creationDate != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
            recipe.setCreationDate(LocalDate.parse(this.creationDate, formatter));
        }

        recipe.setImgUrl(this.imgUrl);

       //USER da dto a user

        if (this.tags != null) {
            List<Tag> tagList = new ArrayList<>();
            for (String tagName : this.tags) {
                Tag tag = new Tag();
                tag.setName(tagName);
                tagList.add(tag);
            }
            recipe.setTag(tagList);
        }

        if (this.recipeSteps != null) {
            List<RecipeStep> recipeStepList = new ArrayList<>();
            for (RecipeStepDto stepDto : this.recipeSteps) {
                recipeStepList.add(stepDto.toRecipeStep());
            }
            recipe.setRecipeSteps(recipeStepList);
        }

        return recipe;
    }




}
