package com.techreturners.movieapi.controller;

import com.techreturners.movieapi.model.UserFavorite;
import com.techreturners.movieapi.service.UserFavoriteManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    /*
    *
    @Post   Mapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book newBook = bookManagerService.insertBook(book);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("book", "/api/v1/book/" + newBook.getId().toString());
        return new ResponseEntity<>(newBook, httpHeaders, HttpStatus.CREATED);
    }*/
}
