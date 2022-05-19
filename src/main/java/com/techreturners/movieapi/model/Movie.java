package com.techreturners.movieapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {

    @Id
    @Column(updatable = false, nullable = false)
    private   long id;

    @Column
    private   String original_language;

    @Column
    private   String release_date;

    @Column
    private   String title;

    @Column
    private   String overview;

    @Column
    private   float vote_average ;

}
