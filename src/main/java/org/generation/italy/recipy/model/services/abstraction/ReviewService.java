package org.generation.italy.recipy.model.services.abstraction;
import org.generation.italy.recipy.dtos.ReviewDto;
import org.generation.italy.recipy.model.entities.Review;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface ReviewService {
    void createReview(ReviewDto reviewDto);
    ReviewDto getReview(Long id);
    List<ReviewDto> getAllReviews();
    void updateReview(Long id, ReviewDto reviewDto);
    void deleteReview(Long id);
}
