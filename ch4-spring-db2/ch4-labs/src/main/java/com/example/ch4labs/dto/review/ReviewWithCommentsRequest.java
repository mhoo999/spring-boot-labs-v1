package com.example.ch4labs.dto.review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewWithCommentsRequest {
	private Boolean includeComments = false;
	private int page = 0;
	private int size = 10;
}
