package com.techreturners.movieapi.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieRecommendations {

     private String page;
     private MovieInfo[] results;
     private long total_pages;
     private long total_results;

     public String getPage() {
          return page;
     }

     public MovieInfo[] getResults() {
          return results;
     }

     public long getTotal_pages() {
          return total_pages;
     }

     public long getTotal_results() {
          return total_results;
     }
}
