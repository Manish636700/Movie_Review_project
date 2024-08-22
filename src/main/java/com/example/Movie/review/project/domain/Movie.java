package com.example.Movie.review.project.domain;


import com.example.Movie.review.project.response.MovieResponse;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="movie_table")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class Movie implements Serializable {

    @Id
    @Column(name="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private Double rating; // a single entity which is average rating of all review for a movie

    @OneToMany(mappedBy = "movie")
    private List<Review> reviews;

    public MovieResponse toMovieResponse()
    {
        return MovieResponse.builder().genre(this.genre).title(this.title).rating(this.rating).reviews(Review.toReviewResponseList(this.reviews)).build();
    }

}
