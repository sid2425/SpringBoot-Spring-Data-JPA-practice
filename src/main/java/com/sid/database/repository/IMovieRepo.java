package com.sid.database.repository;

import com.sid.database.entity.Movie;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IMovieRepo extends PagingAndSortingRepository<Movie, Integer> {
}
