package com.techreturners.movieapi.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Data
public class UserFavorite {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private Integer id;

    @Column(unique = true)
    private String userName;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_movies",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private Set<Movie> movies;

    public boolean removeMovie(Long movieId) {
        Movie movie = this.movies.stream().filter(t -> t.getId() == movieId).findFirst().orElse(null);
        if (movie != null) {
            this.movies.remove(movie);
            return true;
        }
        return false;
    }

}
