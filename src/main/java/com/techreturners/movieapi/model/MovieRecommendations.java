package com.techreturners.movieapi.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieRecommendations {

     private String page;
     private MovieInfo[] results;
     private long total_pages;
     private long total_results;

     public MovieRecommendations(){
          super();
     }

     public MovieRecommendations(String page, MovieInfo[] results, long total_pages, long total_results) {
          this.page = page;
          this.results = results;
          this.total_pages = total_pages;
          this.total_results = total_results;
     }

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
