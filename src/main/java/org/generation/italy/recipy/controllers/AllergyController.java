package org.generation.italy.recipy.controllers;

import org.generation.italy.recipy.dtos.UserDetailDto;
import org.generation.italy.recipy.model.entities.EatingRegime;
import org.generation.italy.recipy.model.entities.User;
import org.generation.italy.recipy.model.services.abstraction.AllergyService;
import org.generation.italy.recipy.model.services.abstraction.EatingRegimeService;
import org.generation.italy.recipy.model.services.abstraction.IntoleranceService;
import org.generation.italy.recipy.model.services.abstraction.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/allergies")
public class AllergyController {

    AllergyService allergyService;

    public AllergyController(AllergyService allergyService) {
        this.allergyService = allergyService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<?> getAllIntolerances(@AuthenticationPrincipal User userAuth) {
        return ResponseEntity.ok(allergyService.findAllAllergies());
    }
}
