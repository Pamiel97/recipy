package org.generation.italy.recipy.model.services.implementation;

import org.generation.italy.recipy.dtos.RecipeDto;
import org.generation.italy.recipy.dtos.ReviewDto;
import org.generation.italy.recipy.dtos.UserDto;
import org.generation.italy.recipy.model.entities.Review;
import org.generation.italy.recipy.model.entities.User;
import org.generation.italy.recipy.model.repositories.ReviewRepositoryJPA;
import org.generation.italy.recipy.model.services.abstraction.RecipeService;
import org.generation.italy.recipy.model.services.abstraction.ReviewService;
import org.generation.italy.recipy.model.services.abstraction.UserService;
import org.generation.italy.recipy.request.ReviewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.NoSuchElementException;

@Service
public class ReviewServiceJpa implements ReviewService {

    @Autowired
    private ReviewRepositoryJPA repository;

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private UserService userService;

    public ReviewServiceJpa(ReviewRepositoryJPA repository, RecipeService recipeService, UserService userService) {
        this.repository = repository;
        this.recipeService = recipeService;
        this.userService = userService;
    }

    @Override
    public ReviewDto createReview(User user, ReviewRequest reviewRequest) {
        //to-do: trasformare ReviewDto nell'entity
        ReviewDto reviewDtoRequest = new ReviewDto();
        //copio i dati dall'oggetto del frontend in dto
        reviewDtoRequest.setText(reviewRequest.getText());
        reviewDtoRequest.setRating(reviewRequest.getRating());
        reviewDtoRequest.setCreationDate(reviewRequest.getCreationDate());
        RecipeDto recipeDto = recipeService.findById(reviewRequest.getRecipeId());
        reviewDtoRequest.setRecipeDto(recipeDto);
        UserDto userDto = userService.findById(user.getId());
        reviewDtoRequest.setUserDto(userDto);
        Review review = ReviewDto.toEntity(reviewDtoRequest);
        Review responceEntity = repository.save(review);
        ReviewDto responceDto = ReviewDto.toDto(responceEntity);
        return responceDto;
    }

    @Override
    public ReviewDto getReview(Long id) {
        Optional<Review> entity = repository.findById(id);
        ReviewDto reviewDto = new ReviewDto();
        ReviewDto reviewDto1 = reviewDto.toDto(entity.get());
        return reviewDto1;
    }

    @Override
    public List<ReviewDto> getAllReviews() {
        List<Review> listEntity = repository.findAll();
        ReviewDto reviewDto = new ReviewDto();
        List<ReviewDto> reviewDtos = listEntity.stream()
                .map(entity -> reviewDto.toDto(entity))
                .collect(Collectors.toList());

        return reviewDtos;
    }

    @Override
    public ReviewDto updateReview(Long id, ReviewRequest reviewDto) {
        // Validazione del DTO
        if (reviewDto == null) {
            throw new IllegalArgumentException("ReviewDto or required fields cannot be null");
        }

        // Trova la review esistente
        Optional<Review> existingReview = repository.findById(id);

        if (existingReview.isPresent()) {
            if (reviewDto.getText() != null) {
                existingReview.get().setText(reviewDto.getText());
            }
            if (reviewDto.getRating() != null) {
                existingReview.get().setRating(reviewDto.getRating());
            }
        } else {
            throw new NoSuchElementException("Review not found with ID: " + id);
        }
        repository.save(existingReview.get());
        return new ReviewDto();
    }


    @Override
    public void deleteReview(Long id) {

        // Controlla se l'ID è nullo
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }

        // Controlla se la review esiste
        Optional<Review> existingReview = repository.findById(id);

        if (existingReview.isPresent()) {
            // Elimina la review
            repository.delete(existingReview.get());
        } else {
            throw new NoSuchElementException("Review not found with ID: " + id);
        }
    }
}
