package org.generation.italy.recipy.model.repositories;

import org.generation.italy.recipy.model.entities.Intolerance;
import org.generation.italy.recipy.model.entities.Pantry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.sql.Into;

import java.util.List;
import java.util.Optional;

public interface IntoleranceRepositoryJpa extends JpaRepository<Intolerance, Long> {
}
