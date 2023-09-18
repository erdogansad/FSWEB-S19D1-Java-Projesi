package com.workintech.S19D1.service;

import java.util.List;

import com.workintech.S19D1.entity.Actor;

public interface ActorService {
    List<Actor> findAll();

    Actor delete(int id);

    Actor findById(int id);

    Actor save(Actor actor);
}
