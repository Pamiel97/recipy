package org.generation.italy.recipy.model.services.implementation;

import org.generation.italy.recipy.model.entities.EatingRegime;
import org.generation.italy.recipy.model.repositories.EatingRegimeRepositoryJPA;
import org.generation.italy.recipy.model.services.abstraction.EatingRegimeService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EatingRegimeServiceJpa implements EatingRegimeService {

    EatingRegimeRepositoryJPA repo;

    public EatingRegimeServiceJpa(EatingRegimeRepositoryJPA repo){
        this.repo=repo;
    }

    @Override
    public Optional<EatingRegime> findById(long id){
        return repo.findById(id);
    }

}
