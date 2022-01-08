package com.sid.database;

import com.sid.database.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DatabaseApplication {

    @Autowired
    IMovieService movieService;

    @Bean
    public ApplicationRunner doWork() {
        return args -> {
            try {
                movieService.getAllMovies().forEach(System.out::println);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        };
    }


    public static void main(String[] args) {
        SpringApplication.run(DatabaseApplication.class, args);
    }

}
