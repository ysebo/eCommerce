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
    public String addReview(@PathVariable Long productId, @RequestBody ReviewRequest reviewRequest){
        reviewService.addReview(productId,reviewRequest);
        return "review was added";
    }
    @PutMapping("/update/{reviewId}")
    public String updateReview(@PathVariable Long reviewId, @RequestBody ReviewRequest reviewRequest){
        reviewService.update(reviewId, reviewRequest);
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
    public String deleteReview(@PathVariable Long reviewId){
        reviewService.deleteReview(reviewId);
        return "review was deleted";
    }
}
