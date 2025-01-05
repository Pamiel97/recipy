package org.generation.italy.recipy.model.services.implementation;

import org.generation.italy.recipy.model.entities.User;
import org.generation.italy.recipy.model.repositories.UserRepositoryJPA;
import org.generation.italy.recipy.model.services.abstraction.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServiceJpa implements UserService {

    private UserRepositoryJPA repo;

    public UserServiceJpa(UserRepositoryJPA repo){
        this.repo=repo;
    }

    @Override
    public Optional<User> findById(long id) {
        return repo.findById(id);
    }

    @Override
    public Optional<User> updateUser(User user){
        return Optional.of(repo.save(user));
    }

}
