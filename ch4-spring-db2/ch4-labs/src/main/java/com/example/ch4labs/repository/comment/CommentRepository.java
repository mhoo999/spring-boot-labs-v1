package com.example.ch4labs.repository.comment;

import com.example.ch4labs.dto.comment.CommentResponse;
import com.example.ch4labs.dto.review.ReviewSearchRequest;
import com.example.ch4labs.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Page<Comment> findByReviewId(Long reviewId, Pageable pageable);
}
