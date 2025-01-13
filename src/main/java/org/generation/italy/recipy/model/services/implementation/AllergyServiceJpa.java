package org.generation.italy.recipy.model.services.implementation;

import org.generation.italy.recipy.model.entities.Allergy;
import org.generation.italy.recipy.model.repositories.AllergyRepositoryJpa;
import org.generation.italy.recipy.model.services.abstraction.AllergyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AllergyServiceJpa implements AllergyService {

    private final AllergyRepositoryJpa allergyRepositoryJpa;

    public AllergyServiceJpa(AllergyRepositoryJpa allergyRepositoryJpa){
        this.allergyRepositoryJpa = allergyRepositoryJpa;
    }

    @Override
    public Optional<Allergy> findAllergyById(long id) {
        return allergyRepositoryJpa.findById(id);
    }

    @Override
    public List<Allergy> findAllAllergies() {
        return allergyRepositoryJpa.findAll();
    }
}
