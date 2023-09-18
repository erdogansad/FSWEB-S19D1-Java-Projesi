package com.workintech.S19D1.service;

import java.util.List;

import com.workintech.S19D1.entity.Movie;

public interface MovieService {
    List<Movie> findAll();

    Movie delete(int id);

    Movie findById(int id);

    Movie save(Movie movie);
}
