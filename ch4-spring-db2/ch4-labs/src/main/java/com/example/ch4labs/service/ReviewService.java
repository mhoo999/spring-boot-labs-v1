package com.example.ch4labs.service;

import com.example.ch4labs.dto.review.*;
import com.example.ch4labs.entity.Review;
import com.example.ch4labs.repository.review.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

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

    public ReviewPageResponse searchReviews(ReviewSearchRequest request) {
        Page<ReviewResponse> page = reviewRepository.search(request);

        return ReviewPageResponse.from(page.getContent(), request, page.getTotalElements());
    }

    public ReviewResponse updateReview(Long reviewId, UpdateReviewRequest request) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new NoSuchElementException("Review not found"));

        review.update(request);

        return ReviewResponse.from(review);
    }

}
