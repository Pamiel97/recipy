package org.generation.italy.recipy.model.services.abstraction;

import org.generation.italy.recipy.model.entities.User;

import java.util.Optional;

public interface UserService {
    //funzione per creare profilo utente
    //funzione per suggerire le ricette in base al p.u.
    Optional<User> findById(long id);
    User createUser(User user);
}
