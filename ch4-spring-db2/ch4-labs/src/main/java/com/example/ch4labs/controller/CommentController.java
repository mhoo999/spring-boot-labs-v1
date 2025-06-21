package com.example.ch4labs.controller;

import com.example.ch4labs.dto.comment.*;
import com.example.ch4labs.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/reviews/{reviewId}/comments")
    public ResponseEntity<CommentResponse> createComment(
            @PathVariable("reviewId") Long reviewId,
            @RequestBody CommentCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(commentService.createComment(reviewId, request));
    }

    @PutMapping("/comments/{commentId}")
    public ResponseEntity<CommentResponse> updateComment(
            @PathVariable("commentId") Long commentId,
            @RequestBody CommentUpdateRequest request) {
        return ResponseEntity.ok(commentService.updateComment(commentId, request));
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<CommentResponse> deleteComment(
            @PathVariable("commentId") Long commentId) {
        commentService.deleteById(commentId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/reviews/{reviewId}/comments")
    public ResponseEntity<CommentPageResponse> getCommentByReview(
            @PathVariable("reviewId") Long reviewId,
            CommentSearchRequest request) {
        return ResponseEntity.ok(commentService.getCommentByReview(reviewId, request));
    }

}
