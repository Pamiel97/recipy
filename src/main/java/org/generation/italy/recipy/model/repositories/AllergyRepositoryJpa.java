package org.generation.italy.recipy.model.repositories;

import org.generation.italy.recipy.model.entities.Allergy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllergyRepositoryJpa extends JpaRepository<Allergy, Long> {
}
