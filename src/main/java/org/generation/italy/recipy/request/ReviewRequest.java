package org.generation.italy.recipy.request;

import org.generation.italy.recipy.dtos.RecipeDto;
import org.generation.italy.recipy.dtos.UserDto;

import java.time.LocalDate;

public class ReviewRequest {

    private String text;
    private Double rating;
    private LocalDate creationDate;
    private Long recipeId;

    public ReviewRequest(String text, Double rating, LocalDate creationDate, Long recipeId) {
        this.text = text;
        this.rating = rating;
        this.creationDate = creationDate;
        this.recipeId = recipeId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }
}
