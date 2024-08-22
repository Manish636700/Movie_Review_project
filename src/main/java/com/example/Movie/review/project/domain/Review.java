package com.example.Movie.review.project.domain;


import com.example.Movie.review.project.response.ReviewResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name="review_table")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Review {

    @Id
    @Column(name="id" , nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String movieReview;

    private double rating;

    @ManyToOne
    @JoinColumn(name="movie_id",nullable = false)
    @JsonIgnore
    private Movie movie;

    @CreationTimestamp
    private Date creationDate;


    @UpdateTimestamp
    private Date updateDate;


    public static ReviewResponse toReviewResponse(Review review) {
        return ReviewResponse.builder().review(review.movieReview).rating(review.rating).build();
    }

    public static List<ReviewResponse> toReviewResponseList(List<Review> reviews) {
        if(Objects.isNull(reviews))
            return new ArrayList<>();
        else
            return reviews.stream().map(Review :: toReviewResponse).collect(Collectors.toList());
    }
}
