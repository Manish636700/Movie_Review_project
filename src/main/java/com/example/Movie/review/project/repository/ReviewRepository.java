package com.example.Movie.review.project.repository;

import com.example.Movie.review.project.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    Optional<Review> findById(long id);

    @Query(value="select avg(rating) from review_table where movie_id=?",nativeQuery = true)
    Double getReviewAverage(Long id);
}
