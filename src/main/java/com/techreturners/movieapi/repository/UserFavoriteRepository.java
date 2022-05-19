package com.techreturners.movieapi.repository;

import com.techreturners.movieapi.model.UserFavorite;
import org.springframework.data.repository.CrudRepository;

public interface UserFavoriteRepository  extends CrudRepository<UserFavorite, Integer> {

}
