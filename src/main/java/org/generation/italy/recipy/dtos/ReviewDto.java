package org.generation.italy.recipy.dtos;

import org.generation.italy.recipy.model.entities.Recipe; // da modificare
import org.generation.italy.recipy.model.entities.Review;
import org.generation.italy.recipy.model.entities.User;

import java.time.LocalDate;

public class ReviewDto {

    private Long id;
    private String text;
    private Double rating;
    private LocalDate creationDate;
    private UserDto userDto;
    private RecipeDto recipeDto;

    public ReviewDto() {
    }

    public ReviewDto(Long id, String text, Double rating, LocalDate creationDate, UserDto userDto, RecipeDto recipeDto) {
        this.id = id;
        this.text = text;
        this.rating = rating;
        this.creationDate = creationDate;
        this.userDto = userDto;
        this.recipeDto = recipeDto;
    }

    public Review toEntity(ReviewDto reviewDto) {
        Review review = new Review();
        if (reviewDto.getId() != null){
            review.setId(reviewDto.getId());
        }
        review.setText(reviewDto.getText());
        review.setRating(reviewDto.getRating());
        review.setCreationDate(reviewDto.getCreationDate());
        review.setUser(new User());
        review.getUser().setId(reviewDto.getUserDto().getId());
        review.setRecipe(new Recipe());
        review.getRecipe().setId(reviewDto.getRecipeDto().getId());
        // Imposta altri campi necessari
        return review;
    }

    public ReviewDto toDto(Review review) {
        ReviewDto dto = new ReviewDto();
        dto.setId(review.getId());
        dto.setText(review.getText());
        dto.setRating(review.getRating());
        dto.setCreationDate(review.getCreationDate());

        UserDto userDto = new UserDto();
        if (review.getUser() != null) {
            userDto.setId(review.getUser().getId());
            userDto.setFirstname(review.getUser().getFirstname());
            userDto.setLastname(review.getUser().getLastname());
        }
        dto.setUserDto(userDto);

        RecipeDto recipeDto = new RecipeDto();
        if (review.getRecipe() != null) {
            recipeDto.setId(review.getRecipe().getId());
            recipeDto.setTitle(review.getRecipe().getTitle());
            recipeDto.setDescription(review.getRecipe().getDescription());
        }
        dto.setRecipeDto(recipeDto);

        // Imposta altri campi necessari
        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public RecipeDto getRecipeDto() {
        return recipeDto;
    }

    public void setRecipeDto(RecipeDto recipeDto) {
        this.recipeDto = recipeDto;
    }

}
