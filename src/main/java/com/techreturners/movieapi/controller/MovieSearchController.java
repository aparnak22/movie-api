package com.techreturners.movieapi.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class MovieSearchController {

    @GetMapping(value="/search")
    public String getRecommendations(){

        String url = "https://api.themoviedb.org/3/discover/movie?api_key=70cb6bbe42e70d00630d60e98da21a75&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=2&with_genres=878&with_watch_monetization_types=flatrate";

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url,String.class);

    }
}
