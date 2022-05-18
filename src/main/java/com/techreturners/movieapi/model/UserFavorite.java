package com.techreturners.movieapi.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserFavorite {

    private String userName;
    private int userId;
    private Movie[] favoriteMovieList;

}
