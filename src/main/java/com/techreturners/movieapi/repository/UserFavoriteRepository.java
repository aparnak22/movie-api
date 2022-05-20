package com.techreturners.movieapi.repository;

import com.techreturners.movieapi.model.UserFavorite;
import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;

public interface UserFavoriteRepository  extends CrudRepository<UserFavorite, Integer> {

    UserFavorite findByUserName(String userName);

}
