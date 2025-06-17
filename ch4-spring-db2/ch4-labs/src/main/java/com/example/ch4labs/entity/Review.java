package com.example.ch4labs.entity;

import com.example.ch4labs.dto.UpdateReviewRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private String author;
    private String bookTitle;
    private String bookAuthor;
    private int rating;

    public void update(UpdateReviewRequest request) {
        this.title = request.getTitle();
        this.content = request.getContent();
        this.author = request.getAuthor();
        this.bookTitle = request.getBookTitle();
        this.bookAuthor = request.getBookAuthor();
        this.rating = request.getRating();
    }
}
