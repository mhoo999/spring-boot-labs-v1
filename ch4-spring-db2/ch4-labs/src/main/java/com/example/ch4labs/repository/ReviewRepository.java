package com.example.ch4labs.repository;

import com.example.ch4labs.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findByTitle(String keyword, Pageable pageable);
    Page<Review> findByAuthor(String author, Pageable pageable);
    Page<Review> findByRatingGreaterThanEqual(int rating, Pageable pageable);
    Page<Review> findByRatingBetween(int minRating, int maxRating, Pageable pageable);
}
