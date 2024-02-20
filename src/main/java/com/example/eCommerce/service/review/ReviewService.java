package com.example.eCommerce.service.review;

import com.example.eCommerce.dto.review.ReviewRequest;
import com.example.eCommerce.dto.review.ReviewResponse;

import java.util.List;

public interface ReviewService{
    void addReview(Long productId, ReviewRequest reviewRequest , String token );

    void update(Long reviewId, ReviewRequest reviewRequest);

    ReviewResponse getReview(Long reviewId);

    List<ReviewResponse> getProductReviews(Long productId);

    void deleteReview(Long reviewId);
}
