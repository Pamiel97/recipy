package org.generation.italy.recipy.controllers;

import org.generation.italy.recipy.dtos.UserDetailDto;
import org.generation.italy.recipy.model.entities.EatingRegime;
import org.generation.italy.recipy.model.entities.User;
import org.generation.italy.recipy.model.services.abstraction.EatingRegimeService;
import org.generation.italy.recipy.model.services.abstraction.IntoleranceService;
import org.generation.italy.recipy.model.services.abstraction.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/intolerance")
public class IntoleranceController {

    IntoleranceService intoleranceService;

    public IntoleranceController(IntoleranceService intoleranceService) {
        this.intoleranceService = intoleranceService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<?> getAllIntolerances(@AuthenticationPrincipal User userAuth) {
        return ResponseEntity.ok(intoleranceService.findAllIntolerances());
    }
}
