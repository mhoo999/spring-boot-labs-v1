package com.example.ch4labs.dto.review;

import com.example.ch4labs.dto.comment.CommentPageResponse;
import com.example.ch4labs.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewWithCommentsResponsePaging {

	private ReviewResponse review;
	private CommentPageResponse commentPage;

	public static ReviewWithCommentsResponsePaging from(Review review, CommentPageResponse commentPageResponse) {
		return ReviewWithCommentsResponsePaging.builder()
			.review(ReviewResponse.from(review))
			.commentPage(commentPageResponse)
			.build();
	}
}
