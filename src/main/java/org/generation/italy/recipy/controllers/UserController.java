package org.generation.italy.recipy.controllers;

import org.generation.italy.recipy.dtos.UserDetailDto;
import org.generation.italy.recipy.dtos.UserDto;
import org.generation.italy.recipy.dtos.security.RegisterRequest;
import org.generation.italy.recipy.model.entities.User;
import org.generation.italy.recipy.model.exceptions.EntityNotFoundException;
import org.generation.italy.recipy.model.services.abstraction.UserService;
import org.generation.italy.recipy.model.services.security.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class UserController {

    UserService userService;
    // AllergyService allergyService;
    // IntolleranceService intolleranceService;
    @Autowired
    AuthService authService;

    public UserController(UserService userService){

        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserDetailDto userDetailDto){
        User user = userDetailDto.toUser();

        try{
            User saved = userService.createUser(user);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}


