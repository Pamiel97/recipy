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
                recipe.getDifficulty().toString(),
                recipe.getkCalories(),
                creationDateString,
                recipe.getImgUrl(),
                userDto,
                tagNames,
                recipeStepDtos
        );
    }


    public Recipe toRecipe(){
        Recipe recipe = new Recipe();
        recipe.setId(this.id);
        recipe.setTitle(this.title);
        recipe.setDescription(this.description);
        recipe.setCourse(Course.valueOf(this.course));
        recipe.setPrepTime(this.prepTime);
        recipe.setPrepTime(this.cookingTime);
        recipe.setDifficulty(Difficulty.valueOf(this.difficulty));
        recipe.setkCalories(this.kCalories);


        if (this.creationDate != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
            recipe.setCreationDate(LocalDate.parse(this.creationDate, formatter));
        }

        recipe.setImgUrl(this.imgUrl);



        if (this.tags != null) {
            List<Tag> tagList = new ArrayList<>();
            for (String tagName : this.tags) {
                Tag tag = new Tag();
                tag.setName(tagName);
                tag.setRecipes(recipe);
                tagList.add(tag);
            }
            recipe.setTag(tagList);
        }

        if (this.recipeSteps != null) {
            List<RecipeStep> recipeStepList = new ArrayList<>();
            for (RecipeStepDto stepDto : this.recipeSteps) {
                RecipeStep rs = stepDto.toRecipeStep();
                rs.setRecipe(recipe);
                recipeStepList.add(rs);
            }
            recipe.setRecipeSteps(recipeStepList);
        }

        return recipe;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public double getkCalories() {
        return kCalories;
    }

    public void setkCalories(double kCalories) {
        this.kCalories = kCalories;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<RecipeStepDto> getRecipeSteps() {
        return recipeSteps;
    }

    public void setRecipeSteps(List<RecipeStepDto> recipeSteps) {
        this.recipeSteps = recipeSteps;
    }
}
