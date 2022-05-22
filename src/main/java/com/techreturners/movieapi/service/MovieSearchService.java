package com.techreturners.movieapi.service;

import com.techreturners.movieapi.model.Certification;
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

    @Value("${external_api_url}")
    private String BASE_URL;

    @Value("${title_api_url}")
    private String TITLE_URL;

    @Value("${test_url}")
    public void setMovieUrl(String urlName) {
        this.MOVIE_URL = urlName;
    }

    @Autowired
    public MovieSearchService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public MovieRecommendations getRecommendations() {
        return getRecommendations(null,-1,0);
    }


    public MovieRecommendations getRecommendations(Certification certificationType) {
        String url = appendCertificationParameter(BASE_URL, certificationType);
        System.out.println("calling " + url);
        MovieRecommendations getMoviesByAge = restTemplate.getForObject(url, MovieRecommendations.class);
        return getMoviesByAge;
    }


    public MovieRecommendations getRecommendations(Certification certificationType, int releaseYear) {
        System.out.println("certificationType" + certificationType);
        String url = appendCertificationParameter(BASE_URL, certificationType);
        url = appendReleaseParameter(url, releaseYear);
        System.out.println("calling " + url);
        return  restTemplate.getForObject(url, MovieRecommendations.class);
    }

    public MovieRecommendations getRecommendations(float voteAverage) {
        String url = appendVoteAverageParameter(BASE_URL, voteAverage);
        System.out.println("calling " + url);
        MovieRecommendations getMoviesGreaterThanVoteAverage = restTemplate.getForObject(url, MovieRecommendations.class);
        return getMoviesGreaterThanVoteAverage;
    }

    public MovieRecommendations getRecommendations(Certification certificationType,
                                                   int releaseYear, float voteAverage) {
        String url = appendCertificationParameter(BASE_URL, certificationType);
        url = appendReleaseParameter(url, releaseYear);
        url = appendVoteAverageParameter(url, voteAverage);
        System.out.println("refactored code calling " + url);
        return  restTemplate.getForObject(url, MovieRecommendations.class);
    }

    public MovieRecommendations getRecommendations(String title) {
        String url = appendTitleParameter(TITLE_URL, title);
        MovieRecommendations getMoviesByTitle = restTemplate.getForObject(url, MovieRecommendations.class);
        System.out.println("calling " + url);
        return getMoviesByTitle;
    }


    private String appendCertificationParameter(String baseURL, Certification certificationType){
        if (certificationType != null)
            baseURL += "&certification_country=GB&certification=" + certificationType.getCertificationCode();
        return baseURL;
    }

    private String appendReleaseParameter(String baseURL, int releaseYear){
        if ( releaseYear != -1) baseURL += "&primary_release_year=" + releaseYear;
        return baseURL;

    }

    private String appendVoteAverageParameter(String baseURL, float voteAverage) {
        if (voteAverage > 0)  return baseURL + "&vote_average.gte=" + voteAverage;
        else return baseURL;
    }

    private String appendTitleParameter(String titleURL, String title){
        titleURL += "&query=" + title;
        return titleURL;

    }
}
