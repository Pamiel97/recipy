package org.generation.italy.recipy.model.services.abstraction;

import org.generation.italy.recipy.model.entities.Allergy;

import java.util.List;
import java.util.Optional;

public interface AllergyService {
    Optional<Allergy> findAllergyById(long id);
    List<Allergy> findAllAllergies();
}
