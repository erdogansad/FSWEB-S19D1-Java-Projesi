package com.workintech.S19D1.mapping;

import com.workintech.S19D1.entity.Actor;
import com.workintech.S19D1.entity.Movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieActorRequest {
    private Movie movie;
    private Actor actor;
}
