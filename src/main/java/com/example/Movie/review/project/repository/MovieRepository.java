package com.example.Movie.review.project.repository;

import com.example.Movie.review.project.domain.Genre;
import com.example.Movie.review.project.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    public Movie findByTitle(String title);

    public List<Movie> findByGenre(Genre genre);
}
