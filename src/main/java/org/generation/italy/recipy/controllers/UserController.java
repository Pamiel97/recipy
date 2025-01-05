package org.generation.italy.recipy.controllers;

import org.generation.italy.recipy.dtos.UserDetailDto;
import org.generation.italy.recipy.model.entities.EatingRegime;
import org.generation.italy.recipy.model.entities.User;
import org.generation.italy.recipy.model.services.abstraction.EatingRegimeService;
import org.generation.italy.recipy.model.services.abstraction.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/users")
public class UserController {

    UserService userService;
    EatingRegimeService eatingRegimeService;

    public UserController(UserService userService, EatingRegimeService eatingRegimeService){
        this.userService = userService;
        this.eatingRegimeService = eatingRegimeService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserDetailDto userDetailDto){
        User userFromDb = userService.findById(userDetailDto.getId()).orElse(null);
        EatingRegime eatingRegime = eatingRegimeService.findById(userDetailDto.getEatingRegimeId()).orElse(null);
        if(userFromDb != null) {
            User user = userDetailDto.toUser(userFromDb, eatingRegime);

            try{
                User saved = userService.updateUser(user).orElse(null);
                if(user != null){
                    return ResponseEntity.ok(saved);
                } else {
                    throw new Exception("User not registered.");
                }
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.notFound().build();
            }
        }

        return ResponseEntity.notFound().build();

    }
}


