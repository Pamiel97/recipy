package org.generation.italy.recipy.model.repositories;

import org.generation.italy.recipy.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryJPA extends JpaRepository<User, Long> {
}
