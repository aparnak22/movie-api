package com.techreturners.movieapi.service;

import com.techreturners.movieapi.model.Movie;
import com.techreturners.movieapi.model.UserFavorite;
import com.techreturners.movieapi.repository.MovieRepository;
import com.techreturners.movieapi.repository.UserFavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserFavoriteManagerServiceImpl implements UserFavoriteManagerService {

    @Autowired
    UserFavoriteRepository userFavoriteRepository;

    @Autowired
    MovieRepository movieRepository;

    @Override
    public UserFavorite createUserFavorite(UserFavorite userFavorite) {

        for(Movie movie:userFavorite.getMovies()){
            movieRepository.save(movie);
        }
        UserFavorite createdUser = userFavoriteRepository.save(userFavorite);
        return createdUser;
    }
}
