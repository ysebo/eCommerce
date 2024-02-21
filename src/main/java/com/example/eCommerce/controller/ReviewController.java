package com.example.eCommerce.controller;

import com.example.eCommerce.dto.review.ReviewRequest;
import com.example.eCommerce.dto.review.ReviewResponse;
import com.example.eCommerce.service.review.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/review")
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("/add/{productId}")
    public String addReview(@PathVariable Long productId, @RequestBody ReviewRequest reviewRequest, @RequestHeader("Authorization") String token){
        reviewService.addReview(productId,reviewRequest, token);
        return "review was added";
    }
    @PutMapping("/update/{reviewId}")
    public String updateReview(@PathVariable Long reviewId, @RequestBody ReviewRequest reviewRequest, @RequestHeader("Authorization") String token){
        reviewService.update(reviewId, reviewRequest, token);
        return "Review was updated";
    }

    @GetMapping("/get/{reviewId}")
    public ReviewResponse getReview(@PathVariable Long reviewId){
        return reviewService.getReview(reviewId);
    }

    @GetMapping("/getAll/{productId}")
    public List<ReviewResponse> getAllReviews(@PathVariable Long productId){
        return reviewService.getProductReviews(productId);
    }

    @DeleteMapping("/delete/{reviewId}")
    public String deleteReview(@PathVariable Long reviewId, @RequestHeader("Authorization") String token){
        reviewService.deleteReview(reviewId,token);
        return "review was deleted";
    }
}
