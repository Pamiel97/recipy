package org.generation.italy.recipy.controllers;

import org.generation.italy.recipy.dtos.AllergyDto;
import org.generation.italy.recipy.dtos.UserDetailDto;
import org.generation.italy.recipy.model.entities.Allergy;
import org.generation.italy.recipy.model.entities.EatingRegime;
import org.generation.italy.recipy.model.entities.User;
import org.generation.italy.recipy.model.services.abstraction.EatingRegimeService;
import org.generation.italy.recipy.model.services.abstraction.IntoleranceService;
import org.generation.italy.recipy.model.services.abstraction.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("api/users")
public class UserController {

    UserService userService;
    EatingRegimeService eatingRegimeService;
    IntoleranceService intoleranceService;

    public UserController(UserService userService, EatingRegimeService eatingRegimeService, IntoleranceService intoleranceService){
        this.userService = userService;
        this.eatingRegimeService = eatingRegimeService;
        this.intoleranceService = intoleranceService;
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<?> createUser(@AuthenticationPrincipal User userAuth, @RequestBody UserDetailDto userDetailDto){
        EatingRegime eatingRegime = eatingRegimeService.findById(userDetailDto.getEatingRegimeId()).orElse(null);
        if(userAuth != null) {
            User user = userDetailDto.toUser(userAuth, eatingRegime);

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

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<?> getProfile(@AuthenticationPrincipal User userAuth){
        User profile = userService.findById(userAuth.getId()).orElse(null);
        if (profile != null) {
            UserDetailDto userDetailDto = UserDetailDto.fromUser(profile);
            return ResponseEntity.ok(userDetailDto);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
