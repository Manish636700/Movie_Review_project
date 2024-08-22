package com.example.Movie.review.project.controller;

import com.example.Movie.review.project.domain.Movie;
import com.example.Movie.review.project.response.MovieResponse;
import com.example.Movie.review.project.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/title")
    public MovieResponse findMovie(@RequestParam String title)
    {
        return movieService.findMovie(title);
    }

    @GetMapping("/genre")
    public List<MovieResponse> findMovieByGenre(@RequestParam String genre)
    {
        return movieService.findMoviesByGenre(genre);
    }


}
