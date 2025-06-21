package com.example.ch4labs.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentSearchRequest {
    private int page = 0;
    private int size = 10;
    private String sort = "createdAt,desc";
}
