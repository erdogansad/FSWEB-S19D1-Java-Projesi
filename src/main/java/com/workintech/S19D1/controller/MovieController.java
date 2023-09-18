package com.workintech.S19D1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workintech.S19D1.entity.Actor;
import com.workintech.S19D1.entity.Movie;
import com.workintech.S19D1.mapping.ActorResponse;
import com.workintech.S19D1.mapping.MovieActorRequest;
import com.workintech.S19D1.mapping.MovieActorResponse;
import com.workintech.S19D1.mapping.MovieResponse;
import com.workintech.S19D1.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {
    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public List<MovieResponse> findAll() {
        List<MovieResponse> movieResponses = new ArrayList<>();
        List<Movie> movies = movieService.findAll();
        for (Movie movie : movies) {
            movieResponses.add(new MovieResponse(movie.getId(), movie.getName(), movie.getDirectorName(),
                    movie.getRating(), movie.getReleaseDate()));
        }
        return movieResponses;
    }

    @GetMapping("/{id}")
    public MovieResponse findById(@PathVariable int id) {
        Movie foundMovie = movieService.findById(id);
        return new MovieResponse(foundMovie.getId(), foundMovie.getName(), foundMovie.getDirectorName(),
                foundMovie.getRating(), foundMovie.getReleaseDate());

    }

    @PostMapping("/")
    public MovieActorResponse save(@RequestBody MovieActorRequest movieActorRequest) {
        Movie movie = movieActorRequest.getMovie();
        Actor actor = movieActorRequest.getActor();
        movie.addActor(actor);
        Movie savedMovie = movieService.save(movie);
        return new MovieActorResponse(savedMovie, actor.getId(), actor.getFirstName(), actor.getLastName(),
                actor.getBirthDate());
    }

    @PostMapping("/addActor/{movieId}")
    public List<ActorResponse> addActor(@RequestBody List<Actor> actors, @PathVariable int movieId) {
        Movie movie = movieService.findById(movieId);
        movie.addAllActor(actors);
        Movie savedMovie = movieService.save(movie);
        List<ActorResponse> actorResponses = new ArrayList<>();
        for (Actor actor : savedMovie.getActors()) {
            actorResponses.add(
                    new ActorResponse(actor.getId(), actor.getFirstName(), actor.getLastName(), actor.getBirthDate()));
        }
        return actorResponses;
    }

    @PutMapping("/{id}")
    public MovieResponse update(@RequestBody Movie movie, @PathVariable int id) {
        Movie foundMovie = movieService.findById(id);
        movie.setId(id);
        movie.setActors(foundMovie.getActors());
        movieService.save(movie);
        return new MovieResponse(movie.getId(), movie.getName(), movie.getDirectorName(),
                movie.getRating(), movie.getReleaseDate());
    }

    @DeleteMapping("/{id}")
    public MovieResponse delete(@PathVariable int id) {
        Movie movie = movieService.delete(id);
        return new MovieResponse(movie.getId(), movie.getName(), movie.getDirectorName(),
                movie.getRating(), movie.getReleaseDate());
    }

}
