package com.techreturners.movieapi.service;

import com.techreturners.movieapi.model.MovieRecommendations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class MovieSearchService {

    private RestTemplate restTemplate;
    private static String MOVIE_URL;

    @Value("${test_url}")
    public void setMovieUrl(String urlName) {
        this.MOVIE_URL = urlName;
    }

    @Autowired
    public MovieSearchService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public MovieRecommendations getRecommendations() {

        MovieRecommendations getAllMovies = restTemplate.getForObject(MOVIE_URL, MovieRecommendations.class);
        //System.out.println("searching ...." + listMovies.getTotal_results());

        return getAllMovies;
    }

}
