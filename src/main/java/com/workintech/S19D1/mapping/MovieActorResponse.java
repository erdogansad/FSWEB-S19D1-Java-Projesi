package com.workintech.S19D1.mapping;

import java.time.LocalDate;

import com.workintech.S19D1.entity.Movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieActorResponse {
    private Movie movie;
    private int actorId;
    private String actorFirstName;
    private String actorLastName;
    private LocalDate actorBirthDate;
}
