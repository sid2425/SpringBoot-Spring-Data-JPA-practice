package com.sid.database.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;


@Data
@ToString
@Entity
@Table(name="movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movie_id")
    private Integer movieId;
    @Column(name = "movie_name")
    private String movieName;

    @Column(name = "release_year")
    private String releaseYear;

    @Column(name = "ratings")
    private Float ratings;

}
