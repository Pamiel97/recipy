package org.generation.italy.recipy.controllers;
import org.generation.italy.recipy.dtos.ReviewDto;
import org.generation.italy.recipy.dtos.UserDto;
import org.generation.italy.recipy.dtos.security.RegisterRequest;
import org.generation.italy.recipy.model.entities.Review;
import org.generation.italy.recipy.model.entities.User;
import org.generation.italy.recipy.model.services.abstraction.ReviewService;
import org.generation.italy.recipy.request.ReviewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

/* to-do: per tutte le api
    il tipo di ritorno deve essere un dto e non un entity
    usare dto nel @RequestBody
*/
    @CrossOrigin
    @PostMapping
    public ResponseEntity<ReviewDto> createReview(@AuthenticationPrincipal User userAuth, @RequestBody ReviewRequest reviewRequest) {
        ReviewDto reviewDto = reviewService.createReview(userAuth, reviewRequest);
        return new ResponseEntity<>(reviewDto, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<ReviewDto> getReview(@PathVariable Long id, @AuthenticationPrincipal User userAuth) {
        ReviewDto reviewDto = reviewService.getReview(id);
        if (reviewDto != null) {
            return new ResponseEntity<>(reviewDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<List<ReviewDto>> getAllReviews(@AuthenticationPrincipal User userAuth) {
        List<ReviewDto> reviews = reviewService.getAllReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReviewDto> updateReview(@PathVariable Long id, @RequestBody ReviewRequest reviewDetails) {
        ReviewDto reviewDto = reviewService.updateReview(id, reviewDetails);
        return new ResponseEntity<>(reviewDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
