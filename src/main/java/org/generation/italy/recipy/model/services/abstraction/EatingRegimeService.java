package org.generation.italy.recipy.model.services.abstraction;

import org.generation.italy.recipy.model.entities.EatingRegime;
import org.generation.italy.recipy.model.entities.Ingredient;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface EatingRegimeService {
    Optional<EatingRegime> findById(long id);
}
