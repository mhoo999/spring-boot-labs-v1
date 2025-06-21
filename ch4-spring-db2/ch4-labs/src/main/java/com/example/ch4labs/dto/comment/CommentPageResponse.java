package com.example.ch4labs.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentPageResponse {
    private List<CommentResponse> content;
    private long totalElements;
    private int totalPages;
    private int size;
    private int page;

    public static CommentPageResponse from(Page<CommentResponse> pages) {
        return CommentPageResponse.builder()
                .content(pages.getContent())
                .totalElements(pages.getTotalElements())
                .totalPages(pages.getTotalPages())
                .size(pages.getSize())
                .page(pages.getNumber())
                .build();
    }
}
