package com.example.Movie.review.project.controller;

import com.example.Movie.review.project.domain.Review;
import com.example.Movie.review.project.request.ReviewRequest;
import com.example.Movie.review.project.response.ReviewResponse;
import com.example.Movie.review.project.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/add")
    public void addReview(@RequestBody ReviewRequest reviewRequest) {
        reviewService.addReview(reviewRequest.toReview());
    }

    @GetMapping("/find")
    public ReviewResponse getReview(@RequestParam Long id) {
        return reviewService.getReviewById(id);
    }
}
