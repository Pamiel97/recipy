package org.generation.italy.recipy.model.repositories;

import org.generation.italy.recipy.model.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepositoryJPA extends JpaRepository<Review, Long> {
}
