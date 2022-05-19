package com.techreturners.movieapi.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieRecommendations {

     private String page;
     private Movie[] results;
     private long total_pages;
     private long total_results;

}
