package com.example.ch4labs.service;

import com.example.ch4labs.dto.CreateReviewRequest;
import com.example.ch4labs.dto.ReviewResponse;
import com.example.ch4labs.dto.UpdateReviewRequest;
import com.example.ch4labs.entity.Review;
import com.example.ch4labs.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewResponse createReview(CreateReviewRequest request) {
        Review review = new Review();
        review.setTitle(request.getTitle());
        review.setAuthor(request.getAuthor());
        review.setRating(request.getRating());
        Review createReview = reviewRepository.save(review);
        return ReviewResponse.from(createReview);
    }

    public List<ReviewResponse> findAllReviews() {
        return reviewRepository.findAll()
                .stream()
                .map(ReviewResponse::from)
                .collect(Collectors.toList());
    }

    public ReviewResponse updateReview(Long reviewId, UpdateReviewRequest request) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(NoSuchElementException::new);

        review.update(request);

        return ReviewResponse.from(review);
    }

}
