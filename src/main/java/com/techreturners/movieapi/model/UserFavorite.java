package com.techreturners.movieapi.model;

public class UserFavorite {

    private String userName;
    private int userId;
//    private List<Movie> favoriteMovieList;

    /*
    public UserFavorite(String userName, int userId, List<Movie> favoriteMovieList) {
        this.userName = userName;
        this.userId = userId;
        this.favoriteMovieList = favoriteMovieList;
    }
    */

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    /*
    public List<Movie> getFavoriteMovieList() {
        return favoriteMovieList;
    }

    public void setFavoriteMovieList(List<Movie> favoriteMovieList) {
        this.favoriteMovieList = favoriteMovieList;
    }
     */
}
