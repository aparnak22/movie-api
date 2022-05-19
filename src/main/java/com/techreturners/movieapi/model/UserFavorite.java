package com.techreturners.movieapi.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class UserFavorite {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private Integer id;

    @Column
    private String userName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "movieId", referencedColumnName = "id")
    private List<Movie> movies;

}
