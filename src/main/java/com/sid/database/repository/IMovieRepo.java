package com.sid.database.repository;

import com.sid.database.entity.Movie;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IMovieRepo extends PagingAndSortingRepository<Movie, Integer> {
    public List<Movie> findByMovieNameEquals(String name);
    public List<Movie> findByMovieNameLike(String pattern);

}
