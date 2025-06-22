package com.example.ch4labs.dto.comment;

import com.example.ch4labs.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentResponse {

    private Long  id;
    private String content;
    private String author;
    private Long reviewId;
    private LocalDateTime createdAt;

    public static CommentResponse from(Comment saved) {
        return CommentResponse.builder()
                .id(saved.getId())
                .content(saved.getContent())
                .author(saved.getAuthor())
                .createdAt(saved.getCreatedAt())
                .build();
    }
}
