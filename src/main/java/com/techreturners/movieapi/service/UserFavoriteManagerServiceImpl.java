package com.techreturners.movieapi.service;

import com.techreturners.movieapi.exception.ResourceNotFoundException;
import com.techreturners.movieapi.exception.ResourceSaveFailedException;
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
    public UserFavorite getUser(String userName){

         UserFavorite user = userFavoriteRepository.findByUserName(userName);
         if  (user == null) throw new ResourceNotFoundException("User: " + userName + " not found. ");
         return user;

    }

    @Override
    public UserFavorite createUserFavorite(UserFavorite userFavorite) {

        UserFavorite savedUser = userFavoriteRepository.findByUserName(userFavorite.getUserName());

        if (savedUser !=null ) throw new ResourceSaveFailedException(userFavorite.getUserName()
                + " already exists. Please choose a different one.");

        for(Movie movie:userFavorite.getMovies()){
            movieRepository.save(movie);
        }
        UserFavorite createdUser = userFavoriteRepository.save(userFavorite);
        return createdUser;
    }

    @Override
    public UserFavorite updateUserFavorite(UserFavorite userFavorite) {
        UserFavorite savedUser = userFavoriteRepository.findByUserName(userFavorite.getUserName());

        if (savedUser == null ) throw new ResourceSaveFailedException(userFavorite.getUserName()
                + " does not exists. Please choose a different one.");

        userFavorite.getMovies().addAll(savedUser.getMovies());

        for(Movie movie:userFavorite.getMovies()){
            movieRepository.save(movie);
        }
        UserFavorite updatedUser = userFavoriteRepository.save(userFavorite);
        return updatedUser;
    }

    @Override
    public void deleteMovieById(String userName, Long movieId){

        UserFavorite user = userFavoriteRepository.findByUserName(userName);
        if (user == null) throw new ResourceNotFoundException("User: " + userName + " not found. ");

        if (user.removeMovie(movieId))
            userFavoriteRepository.save(user);
        else throw new ResourceNotFoundException("Movie id: " + movieId +
                                        " for user: " + userName + " not found. ");
    }

}
