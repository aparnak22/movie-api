package com.techreturners.movieapi.controller;

import com.techreturners.movieapi.model.Certification;
import com.techreturners.movieapi.model.MovieRecommendations;
import com.techreturners.movieapi.service.CertificationCategoryLookupService;
import com.techreturners.movieapi.service.MovieSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class MovieSearchController {

    @Autowired
    MovieSearchService movieSearchService;

    @Autowired
    CertificationCategoryLookupService certificationLookupService;

    @GetMapping(value="/search")
    public ResponseEntity<MovieRecommendations> getAllMovieRecommendations(
                            @RequestParam(value="age", defaultValue = "-1" ) int age ,
                            @RequestParam(value = "release_year", defaultValue = "-1") int releaseYear,
                            @RequestParam(value = "vote_average", defaultValue = "0") float vote_average ) {

        System.out.println("searching by all release_year, age, vote_average");
        Certification certification = null;
        if ( age != -1 ) {
            certification = certificationLookupService.getCertification(age);
        }
        MovieRecommendations result = movieSearchService.getRecommendations(certification, releaseYear, vote_average);
       return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/searchbytitle", params = "title", method = GET)
    public ResponseEntity<MovieRecommendations> getMovieRecommendations(@RequestParam("title") String title) {
        System.out.println("searching by title");
        MovieRecommendations result = movieSearchService.getRecommendations(title);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
