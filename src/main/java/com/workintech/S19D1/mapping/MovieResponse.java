package com.workintech.S19D1.mapping;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponse {
    private int movieId;
    private String name;
    private String directorName;
    private int rating;
    private LocalDate releaseDate;
}
