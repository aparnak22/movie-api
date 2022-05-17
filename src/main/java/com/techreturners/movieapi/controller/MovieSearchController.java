package com.techreturners.movieapi.controller;

import com.techreturners.movieapi.model.MovieRecommendations;
import com.techreturners.movieapi.service.MovieSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieSearchController {

    @Autowired
    MovieSearchService movieSearchService;

    @GetMapping(value="/search")
    public ResponseEntity<MovieRecommendations> getAllMovieRecommendations() {
        MovieRecommendations result = movieSearchService.getRecommendations();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
