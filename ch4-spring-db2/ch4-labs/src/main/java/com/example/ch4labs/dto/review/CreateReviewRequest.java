package com.example.ch4labs.dto.review;

import com.example.ch4labs.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateReviewRequest {
    private String title;
    private String content;
    private String author;
    private String bookTitle;
    private String bookAuthor;
    private int rating;

    public Review toEntity() {
        Review review = new Review();
        review.setTitle(title);
        review.setContent(content);
        review.setAuthor(author);
        review.setBookTitle(bookTitle);
        review.setBookAuthor(bookAuthor);
        review.setRating(rating);
        return  review;
    }
}
