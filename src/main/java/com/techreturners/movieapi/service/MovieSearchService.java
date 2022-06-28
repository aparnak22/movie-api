package com.techreturners.movieapi.service;

import com.techreturners.movieapi.model.Certification;
import com.techreturners.movieapi.model.MovieRecommendations;

public interface MovieSearchService {
    MovieRecommendations getRecommendations(Certification certificationType);

    MovieRecommendations getRecommendations(Certification certificationType, int releaseYear);

    MovieRecommendations getRecommendations(float voteAverage);

    MovieRecommendations getRecommendations(Certification certificationType,
                                            int releaseYear, float voteAverage);

    MovieRecommendations getRecommendations(String title);


    MovieRecommendations getRecommendations();

}
