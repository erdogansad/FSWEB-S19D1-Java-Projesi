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
import com.workintech.S19D1.mapping.MovieResponse;
import com.workintech.S19D1.service.ActorService;

@RestController
@RequestMapping("/actors")
public class ActorController {
    private ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/")
    public List<ActorResponse> fidAll() {
        List<Actor> actors = actorService.findAll();
        List<ActorResponse> actorResponses = new ArrayList<>();
        for (Actor actor : actors) {
            List<MovieResponse> movieResponses = new ArrayList<>();
            for (Movie movie : actor.getMovies()) {
                movieResponses.add(new MovieResponse(movie.getId(), movie.getName(), movie.getDirectorName(),
                        movie.getRating(), movie.getReleaseDate()));
            }
            actorResponses
                    .add(new ActorResponse(actor.getId(), actor.getFirstName(), actor.getLastName(),
                            actor.getBirthDate()));
        }
        return actorResponses;

    }

    @GetMapping("/{id}")
    public ActorResponse findById(@PathVariable int id) {
        Actor foundActor = actorService.findById(id);
        List<MovieResponse> movieResponses = new ArrayList<>();
        for (Movie movie : foundActor.getMovies()) {
            movieResponses.add(new MovieResponse(movie.getId(), movie.getName(), movie.getDirectorName(),
                    movie.getRating(), movie.getReleaseDate()));
        }
        return new ActorResponse(foundActor.getId(), foundActor.getFirstName(), foundActor.getLastName(),
                foundActor.getBirthDate());
    }

    @PostMapping("/")
    public ActorResponse save(@RequestBody Actor actor) {
        Actor savedActor = actorService.save(actor);
        List<MovieResponse> movieResponses = new ArrayList<>();
        for (Movie movie : savedActor.getMovies()) {
            movieResponses.add(new MovieResponse(movie.getId(), movie.getName(), movie.getDirectorName(),
                    movie.getRating(), movie.getReleaseDate()));
        }
        return new ActorResponse(savedActor.getId(), savedActor.getFirstName(), savedActor.getLastName(),
                actor.getBirthDate());
    }

    @PutMapping("/{id}")
    public ActorResponse update(@RequestBody Actor actor, @PathVariable int id) {
        Actor foundActor = actorService.findById(id);
        foundActor.setFirstName(actor.getFirstName());
        foundActor.setLastName(actor.getLastName());
        foundActor.setBirthDate(actor.getBirthDate());
        Actor updatedActor = actorService.save(foundActor);
        List<MovieResponse> movieResponses = new ArrayList<>();
        for (Movie movie : updatedActor.getMovies()) {
            movieResponses.add(new MovieResponse(movie.getId(), movie.getName(), movie.getDirectorName(),
                    movie.getRating(), movie.getReleaseDate()));
        }
        return new ActorResponse(updatedActor.getId(), updatedActor.getFirstName(), updatedActor.getLastName(),
                updatedActor.getBirthDate());
    }

    @DeleteMapping("/{id}")
    public ActorResponse delete(@PathVariable int id) {
        Actor deletedActor = actorService.delete(id);
        List<MovieResponse> movieResponses = new ArrayList<>();
        for (Movie movie : deletedActor.getMovies()) {
            movieResponses.add(new MovieResponse(movie.getId(), movie.getName(), movie.getDirectorName(),
                    movie.getRating(), movie.getReleaseDate()));
        }
        return new ActorResponse(deletedActor.getId(), deletedActor.getFirstName(), deletedActor.getLastName(),
                deletedActor.getBirthDate());
    }
}
