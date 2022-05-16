package com.techreturners.movieapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    Integer id;

    @Column
    boolean adult;

    @Column
    String overview;

    @Column
    String releaseDate;

    @Column
    Genre genre;

    @Column
    String originalTitle;

    @Column
    String originalLanguage;

    @Column
    Integer voteCount;

    @Column
    Double voteAverage;

    @Column
    Certification certification;

}
