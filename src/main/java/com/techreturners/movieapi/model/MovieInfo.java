package com.techreturners.movieapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieInfo {

    private   long id;
    private   String original_language;
    private   String release_date;
    private   String title;
    private   String overview;
    private   float vote_average ;

    public long getId() {
        return id;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public float getVote_average(){ return vote_average;}
}
