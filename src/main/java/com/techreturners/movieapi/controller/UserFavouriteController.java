package com.techreturners.movieapi.controller;

import com.techreturners.movieapi.model.UserFavorite;
import com.techreturners.movieapi.service.UserFavoriteManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class UserFavouriteController {
    @Autowired
    UserFavoriteManagerService userFavoriteManagerService;

    @GetMapping(value = "/userfavorite")
    public ResponseEntity<UserFavorite> getUserFavorite(@RequestParam("user_name") String userName){
        System.out.println("Look up user");
        UserFavorite userFavorite = userFavoriteManagerService.getUser(userName);
        return new ResponseEntity<>(userFavorite, HttpStatus.OK);
    }

    @PostMapping(value = "/userfavorite")
    public ResponseEntity<UserFavorite> addUserFavorite(@RequestBody UserFavorite userFavorite){
        System.out.println("Received request");
        UserFavorite newUser = userFavoriteManagerService.createUserFavorite(userFavorite);
        HttpHeaders httpHeaders = new HttpHeaders();

        //httpHeaders.add("userFavorite", "//" + newBook.getId().toString());
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping(value = "/userfavorite")
    public ResponseEntity<UserFavorite> updateUserFavorite(@RequestBody UserFavorite userFavorite){
        System.out.println("Received request - updateUserFavorite");
        UserFavorite updatedFavorite = userFavoriteManagerService.updateUserFavorite(userFavorite);
        HttpHeaders httpHeaders = new HttpHeaders();

        return new ResponseEntity<>(updatedFavorite, HttpStatus.OK);
    }

    @DeleteMapping(value = "/userfavorite")
    public ResponseEntity<String> deleteUserFavorite(@RequestParam("user_name") String userName,
                                                     @RequestParam("movie_id" ) Long movieId){
        System.out.println("Delete user's favourite movie request ");
        try {
            userFavoriteManagerService.deleteMovieById(userName, movieId);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found", e);
        }
        return new ResponseEntity<>("Successfully deleted movie id: " + movieId + " for User: "
                + userName, HttpStatus.OK);
    }

}
