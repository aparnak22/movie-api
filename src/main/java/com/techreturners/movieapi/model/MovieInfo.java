package com.techreturners.movieapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieInfo {

    private   long id;
    private   String original_language;
    private   String release_date;
    private   String title;
    private   String overview;
    private   float vote_average ;

}
