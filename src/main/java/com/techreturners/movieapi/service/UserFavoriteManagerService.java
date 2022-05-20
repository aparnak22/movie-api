package com.techreturners.movieapi.service;

import com.techreturners.movieapi.model.UserFavorite;

import java.util.List;

public interface UserFavoriteManagerService {

    UserFavorite getUser(String userName);

    UserFavorite createUserFavorite(UserFavorite userFavorite);

 //   UserFavorite getUserById(Long id);

  //  UserFavorite addMovie(UserFavorite userFavorite);

}
