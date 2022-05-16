package com.techreturners.movieapi.controller;

import com.techreturners.movieapi.model.MovieRecommendations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieSearchController {


    @GetMapping(value="/search")
    public MovieRecommendations getRecommendations(){

        String url = "https://api.themoviedb.org/3/discover/movie?api_key=70cb6bbe42e70d00630d60e98da21a75&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=2&with_genres=878&with_watch_monetization_types=flatrate";

        RestTemplate restTemplate = new RestTemplate();

        MovieRecommendations result =  restTemplate.getForObject(url, MovieRecommendations.class);
        System.out.println("searching ...." + result.getTotal_results());
        return result;

    }
}
