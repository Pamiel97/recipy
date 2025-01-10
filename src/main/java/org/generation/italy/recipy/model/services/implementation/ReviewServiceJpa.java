package org.generation.italy.recipy.model.services.implementation;

import org.generation.italy.recipy.dtos.ReviewDto;
import org.generation.italy.recipy.model.entities.Review;
import org.generation.italy.recipy.model.repositories.ReviewRepositoryJPA;
import org.generation.italy.recipy.model.services.abstraction.ReviewService;
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

    public ReviewServiceJpa(ReviewRepositoryJPA repository) {
        this.repository = repository;
    }

    @Override
    public void createReview(ReviewDto reviewDto) {
        //to-do: trasformare ReviewDto nell'entity
        Review review = reviewDto.toEntity(reviewDto);
        repository.save(review);
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
    public void updateReview(Long id, ReviewDto reviewDto) {
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
