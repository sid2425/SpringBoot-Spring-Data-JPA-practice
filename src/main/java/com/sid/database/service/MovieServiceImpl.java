package com.sid.database.service;

import com.sid.database.entity.Movie;
import com.sid.database.repository.IMovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements IMovieService{
    @Autowired
    IMovieRepo movieRepo;
    @Override
    public void registerMovie(Movie movie) {
        System.out.println("Before saving ::" + movie);
        Movie movie1 = movieRepo.save(movie);
        System.out.println("After saving ::" + movie1);
    }

    @Override
    public void registerAllMovies(List<Movie> movies) {
        List<Movie> movieList = (List<Movie>) movieRepo.saveAll(movies);
        System.out.println("After Saving ::");
        movieList.forEach(System.out::println);
    }

    @Override
    public long moviesInTotal() {
        return movieRepo.count();
    }

    @Override
    public List<Movie> getAllMovies(boolean inAsc, String ...properties) {
        Sort sort = Sort.by(inAsc ? Sort.Direction.ASC : Sort.Direction.DESC, properties);
        return (List<Movie>) movieRepo.findAll(sort);
    }

    @Override
    public List<Movie> getPaginatedMovies(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Movie> page = movieRepo.findAll(pageable);
        return page.getContent();
    }

    @Override
    public void getAllMovies(int pageSize) {
        long recordsCount = movieRepo.count();
        int pagesCount = (int) (recordsCount / pageSize);
        pagesCount = recordsCount % pageSize == 0 ? pagesCount : ++pagesCount;
        for (int pageNo = 0; pageNo < pagesCount ; pageNo++) {
            Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.ASC, "ratings"));
            Page<Movie> page = movieRepo.findAll(pageable);
            System.out.println("Page No:" + (pageNo + 1) +" Page Size:" + pageSize);
            System.out.println("Page Content of page ::" + pageNo + 1);
            List<Movie> movies = page.getContent();
            for (Movie movie : movies) {
                System.out.println(movie);
            }
        }
    }

    @Override
    public void deleteMovieById(Integer movieId) {
        movieRepo.deleteById(movieId);
    }

    @Override
    public List<Movie> getAllMovies() {
        return (List<Movie>) movieRepo.findAll();
    }

    @Override
    public List<Movie> getMovieByName(String movieName) {
        return movieRepo.findByMovieNameEquals(movieName);
    }

    @Override
    public List<Movie> getMovieByPattern(String pattern) {
        return movieRepo.findByMovieNameLike(pattern);
    }


}
