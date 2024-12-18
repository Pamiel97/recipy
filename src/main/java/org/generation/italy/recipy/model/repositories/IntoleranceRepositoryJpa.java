package org.generation.italy.recipy.model.repositories;

import org.generation.italy.recipy.model.entities.Intolerance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntoleranceRepositoryJpa extends JpaRepository<Intolerance, Long> {
}
