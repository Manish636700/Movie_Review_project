package com.example.Movie.review.project.request;


import com.example.Movie.review.project.domain.Genre;
import com.example.Movie.review.project.domain.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieRequest {

        private String title;
        private Genre genre;

        public Movie toMovie()
        {
            return Movie.builder().title(title).genre(genre).rating(0.0).build();
        }
}
