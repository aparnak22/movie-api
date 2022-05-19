package com.techreturners.movieapi.repository;

import com.techreturners.movieapi.model.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long> {

}
