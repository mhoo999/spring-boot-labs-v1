package com.example.ch4labs.controller;

import com.example.ch4labs.dto.comment.CommentSearchRequest;
import com.example.ch4labs.dto.review.*;
import com.example.ch4labs.repository.review.ReviewRepository;
import com.example.ch4labs.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;
    private final ReviewRepository reviewRepository;

    @PostMapping
    public ResponseEntity<ReviewResponse> createReview(@RequestBody CreateReviewRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(reviewService.createReview(request));
    }

//    @GetMapping
//    public ResponseEntity<List<ReviewResponse>> findAllReviews() {
//        return ResponseEntity.ok(reviewService.findAllReviews());
//    }

    @GetMapping
    public ResponseEntity<ReviewPageResponse> searchReviews(ReviewSearchRequest request) {
        return ResponseEntity.ok(reviewService.searchReviews(request));
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<ReviewWithCommentsResponsePaging> searchReview(@PathVariable Long reviewId, ReviewWithCommentsRequest request) {
        return ResponseEntity.ok(reviewService.searchReview(reviewId, request));
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<ReviewResponse> updateReview(@PathVariable Long reviewId, @RequestBody UpdateReviewRequest request) {
        return ResponseEntity.ok(reviewService.updateReview(reviewId, request));
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long reviewId) {
        reviewRepository.deleteById(reviewId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
