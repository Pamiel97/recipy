package org.generation.italy.recipy.dtos;

import org.generation.italy.recipy.model.entities.Recipe; // da modificare
import org.generation.italy.recipy.model.entities.Review;

import java.time.format.DateTimeFormatter;

public record ReviewDto(String text, double rating, String creationDate, UserDto userDto, Recipe recipe) {

    public static ReviewDto fromReview(Review review){
        return new ReviewDto(review.getText(),
                review.getRating(),
                review.getCreationDate().format(DateTimeFormatter.ISO_LOCAL_DATE),
                UserDto.fromUser(review.getUser()),
                review.getRecipe() // da modificare
        );
    }
}
