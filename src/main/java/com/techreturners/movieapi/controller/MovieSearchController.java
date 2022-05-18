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
    public ResponseEntity<MovieRecommendations> getAllMovieRecommendations() {
        MovieRecommendations result = movieSearchService.getRecommendations();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @RequestMapping(value = "/search", params = "age", method = GET)
    public ResponseEntity<MovieRecommendations> getMovieRecommendations(@RequestParam("age") int age) {
        System.out.println("searching by age");
        MovieRecommendations result = movieSearchService.getRecommendations(certificationLookupService.getCertification(age));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/search", params = {"age" , "release_year"}, method = GET)
    public ResponseEntity<MovieRecommendations> getMovieRecommendations(@RequestParam(value="age", defaultValue = "-1" ) int age ,
                                                                  @RequestParam("release_year" ) int releaseYear ) {
        System.out.println("searching by release_year, age");
        Certification certification = null;
        if ( age != -1 ) {
            certification = certificationLookupService.getCertification(age);
        }
        MovieRecommendations result = movieSearchService.getRecommendations(certification, releaseYear);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
