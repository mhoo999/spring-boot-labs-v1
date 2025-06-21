package com.example.ch4labs.repository;

import com.example.ch4labs.dto.ReviewResponse;
import com.example.ch4labs.dto.ReviewSearchRequest;
import com.example.ch4labs.entity.QReview;
import com.example.ch4labs.entity.Review;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class ReviewQueryRepositoryImpl implements ReviewQueryRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<ReviewResponse> search(ReviewSearchRequest request) {

        QReview review = QReview.review;

        BooleanBuilder builder = new BooleanBuilder();

        // 리뷰 작성자 (정확 일치)
        if (StringUtils.hasText(request.getAuthor())){
            builder.and(review.author.eq(request.getAuthor()));
        }

        // 책 제목 (정확 일치)
        if (StringUtils.hasText(request.getBookTitle())){
            builder.and(review.bookTitle.eq(request.getBookTitle()));
        }

        // 책 제목 키워드 포함 검색
        if (StringUtils.hasText(request.getBookTitleContains())){
            builder.and(review.bookTitle.contains(request.getTitleContains()));
        }

        // 책 저자 (정확 일치)
        if (StringUtils.hasText(request.getBookAuthor())){
            builder.and(review.bookAuthor.eq(request.getBookAuthor()));
        }

        // 리뷰 제목 키워드 포함 검색
        if (StringUtils.hasText(request.getTitleContains())){
            builder.and(review.title.contains(request.getTitleContains()));
        }

        // 리뷰 본문 키워드 포함 검색
        if (StringUtils.hasText(request.getContentContains())){
            builder.and(review.content.contains(request.getContentContains()));
        }

        // 정확 평점 (1~5)
        if (request.getRating() != null){
            builder.and(review.rating.eq(request.getRating()));
        }

        // 최소 평점
        if (request.getMinRating() != null){
            builder.and(review.rating.goe(request.getMinRating()));
        }

        // 최대 평점
        if (request.getMaxRating() != null){
            builder.and(review.rating.loe(request.getMaxRating()));
        }

        // 정렬 기준
        String[] parts = request.getSort().split(",");
        String sortBy = parts[0];
        boolean isAsc = !"desc".equalsIgnoreCase(parts[1]);
        OrderSpecifier<?> orderSpecifier = getOrderSpecifier(sortBy, isAsc);

        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());

        List<Review> reviews = queryFactory.selectFrom(review)
                .where(builder)
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .orderBy(orderSpecifier)
                .fetch();

        long total = queryFactory.select(review.count())
                .from(review)
                .where(builder)
                .fetchOne();

        List<ReviewResponse> content = reviews.stream().map(ReviewResponse::from).toList();

        return new PageImpl<>(content, pageable, total);
    }

    private OrderSpecifier<?> getOrderSpecifier(String sortBy, boolean isAsc) {
        QReview review = QReview.review;
        Order direction = isAsc ? Order.ASC : Order.DESC;

        return switch (sortBy) {
            case "title" -> new OrderSpecifier<>(direction, review.title);
            case "author" -> new OrderSpecifier<>(direction, review.author);
            case "bookAuthor" -> new OrderSpecifier<>(direction, review.bookAuthor);
            case "rating" -> new OrderSpecifier<>(direction, review.rating);
            default -> new OrderSpecifier<>(direction, review.bookTitle);
        };
    }
}
