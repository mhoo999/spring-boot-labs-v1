package com.example.ch4labs.dto;

import com.example.ch4labs.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResponse {
    private Long id;
    private String title;
    private String content;
    private String author;
    private String bookTitle;
    private String bookAuthor;
    private int rating;

    public static ReviewResponse from(Review createReview) {
        return new ReviewResponse(
                createReview.getId(),
                createReview.getTitle(),
                createReview.getContent(),
                createReview.getAuthor(),
                createReview.getBookTitle(),
                createReview.getBookAuthor(),
                createReview.getRating()
        );
    }
}
