package com.example.ch4labs.service;

import com.example.ch4labs.dto.*;
import com.example.ch4labs.entity.Review;
import com.example.ch4labs.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        Review review = request.toEntity();
        Review createReview = reviewRepository.save(review);
        return ReviewResponse.from(createReview);
    }

//    public List<ReviewResponse> findAllReviews() {
//        return reviewRepository.findAll()
//                .stream()
//                .map(ReviewResponse::from)
//                .collect(Collectors.toList());
//    }

    public ReviewPageResponse findAllReviews(ReviewSearchRequest request) {
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());
        Page<Review> reviews = null;

        if (request.getKeyword() != "") {
            reviews = reviewRepository.findByTitle(request.getKeyword(), pageable);
        } else if (request.getAuthor() != null) {
            reviews = reviewRepository.findByAuthor(request.getAuthor(), pageable);
        } else if (request.getRating() != null) {
            reviews = reviewRepository.findByRatingGreaterThanEqual(request.getRating(), pageable);
        } else if (request.getMinRating() != null &&  request.getMaxRating() != null) {
            reviews = reviewRepository.findByRatingBetween(request.getMinRating(), request.getMaxRating(), pageable);
        } else {
            reviews = reviewRepository.findAll(pageable);
        }

        Page<ReviewResponse> page = reviews.map(ReviewResponse::from);

        return ReviewPageResponse.from(page.getContent(), request, page.getTotalElements());
    }

    public ReviewResponse updateReview(Long reviewId, UpdateReviewRequest request) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new NoSuchElementException("Review not found"));

        review.update(request);

        return ReviewResponse.from(review);
    }

}
