package com.example.ch4labs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewSearchRequest {
    private String keyword = "";
    private String author;
    private Integer rating;
    private Integer minRating;
    private Integer maxRating;
    private int page = 0;
    private int size = 10;
}
