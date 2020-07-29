package com.example.moviecatalogservice.models;

public class Movie {
    private String name;
    private int movieId;

    public Movie() {
    }

    public Movie(int movieId, String name) {
        this.name = name;
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
}
