package org.generation.italy.recipy.model.services.implementation;

import org.generation.italy.recipy.dtos.UserDto;
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
    public UserDto findById(long id) {
        Optional<User> userEntity = repo.findById(id);
        UserDto userDto = UserDto.fromUser(userEntity.get());
        return userDto;
    }

    @Override
    public Optional<User> updateUser(User user){
        return Optional.of(repo.save(user));
    }

}
