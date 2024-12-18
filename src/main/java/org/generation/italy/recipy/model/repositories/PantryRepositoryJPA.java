package org.generation.italy.recipy.model.repositories;

import org.generation.italy.recipy.dtos.PantryDto;
import org.generation.italy.recipy.model.entities.Pantry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PantryRepositoryJPA extends JpaRepository<Pantry, Long> {
}
