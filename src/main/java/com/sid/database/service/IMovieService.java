package com.sid.database.service;

import com.sid.database.entity.Movie;

import java.util.List;

public interface IMovieService {
    void registerMovie(Movie movie);
    void registerAllMovies(List<Movie>movies);
    long moviesInTotal();
    List<Movie> getAllMovies(boolean inAsc, String ...properties);
    List<Movie> getPaginatedMovies(int pageNo, int pageSize);
    void getAllMovies(int pageSize);
    void deleteMovieById(Integer movieId);
    List<Movie> getAllMovies();
    List<Movie> getMovieByName(String movieName);
    List<Movie> getMovieByPattern(String pattern);

}
