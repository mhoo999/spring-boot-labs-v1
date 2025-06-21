package com.example.ch4labs.service;

import com.example.ch4labs.dto.comment.*;
import com.example.ch4labs.entity.Comment;
import com.example.ch4labs.entity.Review;
import com.example.ch4labs.repository.comment.CommentRepository;
import com.example.ch4labs.repository.review.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Builder
@Transactional
public class CommentService {

    private final CommentRepository commentRepository;
    private final ReviewRepository reviewRepository;

    public CommentResponse createComment(Long reviewId, CommentCreateRequest request) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new EntityNotFoundException("Review not found"));

        Comment comment = Comment.builder()
                .content(request.getContent())
                .author(request.getAuthor())
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        Comment saved = commentRepository.save(comment);
        return CommentResponse.from(saved);
    }

    public CommentResponse updateComment(Long commentId, CommentUpdateRequest request) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new EntityNotFoundException("Comment not found"));

        comment.setContent(request.getContent());
        comment.setUpdatedAt(LocalDateTime.now());

        return CommentResponse.from(comment);
    }

    public void deleteById(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    @Transactional(readOnly = true)
    public CommentPageResponse getCommentByReview(Long reviewId, CommentSearchRequest request) {
        String[] sort = request.getSort().split(",");
        String properties = sort[0];
        Sort.Direction direction = Sort.Direction.fromString(sort[1]);
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize(), Sort.by(direction, properties));

        Page<Comment> comments = commentRepository.findByReviewId(reviewId, pageable);
        Page<CommentResponse> commentResponses = comments.map(comment -> CommentResponse.from(comment));
        return CommentPageResponse.from(commentResponses);
    }
}
