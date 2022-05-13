package com.techreturners.movieapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @GetMapping(value = "/")
    public String home(){
        return "Welcome to the Movie API!";
    }
}
