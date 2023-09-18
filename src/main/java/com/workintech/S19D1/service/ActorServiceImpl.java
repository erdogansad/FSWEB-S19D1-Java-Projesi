package com.workintech.S19D1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workintech.S19D1.dao.ActorRepository;
import com.workintech.S19D1.entity.Actor;

@Service
public class ActorServiceImpl implements ActorService {
    private ActorRepository actorRepository;

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    @Override
    public Actor delete(int id) {
        Actor actor = findById(id);
        actorRepository.delete(actor);
        return actor;
    }

    @Override
    public Actor findById(int id) {
        Optional<Actor> optionalActor = actorRepository.findById(id);
        if (optionalActor.isPresent()) {
            optionalActor.get();
        }
        return null;
    }

    @Override
    public Actor save(Actor actor) {
        return actorRepository.save(actor);
    }
}
