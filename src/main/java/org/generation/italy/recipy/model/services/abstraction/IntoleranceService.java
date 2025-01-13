package org.generation.italy.recipy.model.services.abstraction;

import org.generation.italy.recipy.model.entities.Intolerance;
import org.generation.italy.recipy.model.entities.Pantry;

import java.util.List;
import java.util.Optional;

public interface IntoleranceService {
    Optional<Intolerance> findIntoleranceById(long id);
    List<Intolerance> findAllIntolerances();
}
