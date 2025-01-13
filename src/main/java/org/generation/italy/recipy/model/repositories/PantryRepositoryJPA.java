package org.generation.italy.recipy.model.repositories;


import org.generation.italy.recipy.model.entities.Pantry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PantryRepositoryJPA extends JpaRepository<Pantry, Long> {
    List<Pantry> findByIngredientIdAndUserId(long ingredientId, long userId);
    List<Pantry> findByUserId(long userId);
    Pantry findByIdAndUserId(long pantryId, long userId);
//    List<Pantry> findByUserEmail(String email);

    @Query("SELECT p FROM Pantry p WHERE p.user.id = :userId")
    Page<Pantry> findUserPantries(Pageable pageable, @Param("userId") long userId);
}
