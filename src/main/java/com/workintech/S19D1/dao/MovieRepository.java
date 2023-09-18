package com.workintech.S19D1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workintech.S19D1.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
