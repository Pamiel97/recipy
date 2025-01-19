package org.generation.italy.recipy.model.services.abstraction;
import org.generation.italy.recipy.dtos.ReviewDto;
import org.generation.italy.recipy.model.entities.Review;
import org.generation.italy.recipy.model.entities.User;
import org.generation.italy.recipy.request.ReviewRequest;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface ReviewService {
    ReviewDto createReview(User user, ReviewRequest request);
    ReviewDto getReview(Long id);
    List<ReviewDto> getAllReviewsByRecipeId(User user, Long recipeId);
    ReviewDto updateReview(Long id, ReviewRequest request);
    void deleteReview(Long id);
}
