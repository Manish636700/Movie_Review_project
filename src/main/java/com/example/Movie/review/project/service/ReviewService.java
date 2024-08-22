package com.example.Movie.review.project.service;

import com.example.Movie.review.project.domain.Movie;
import com.example.Movie.review.project.domain.Review;
import com.example.Movie.review.project.repository.MovieRepository;
import com.example.Movie.review.project.repository.ReviewRepository;
import com.example.Movie.review.project.response.ReviewResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Transactional
    public void addReview(Review review) {
        Movie movie = movieRepository.findById(review.getMovie().getId()).orElse(null);
        //need to optimized
        //
        reviewRepository.save(review);
        if(movie != null) {
            Double average = reviewRepository.getReviewAverage(movie.getId());
            movie.setRating(average);
            movieRepository.save(movie);
        }
    }

    //@Transactional
    public ReviewResponse getReviewById(Long id) {
        Optional<Review>review=reviewRepository.findById(id);
        return review.map(Review :: toReviewResponse).orElse(null);
    }
}
