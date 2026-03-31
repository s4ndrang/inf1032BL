package com.example.inf1032BL.controller;

import com.example.inf1032BL.entity.Coach;
import com.example.inf1032BL.service.CoachService;
import dto.CoachDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bl/coach/")
public class CoachController {
    private final CoachService coachService;

    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }
    @PostMapping(path = "create-account", produces="application/json")
    public ResponseEntity<String> createCoach(@RequestBody CoachDTO coachDTO) {
        Coach savedCoach = coachService.createNewCoach(coachDTO.toModel());
        return savedCoach != null?  ResponseEntity
                .ok("Success") :
                ResponseEntity
                        .status(HttpStatus.FORBIDDEN)
                        .body("Error");
    }

    //The @Secured annotation is used to specify a list of roles on a method. So, a user only can access that method if she has at least one of the specified roles.
    //@PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping(path = "all")
    public List<CoachDTO> fetchAllCoaches() {
        List<Coach> coaches = coachService.getAllCoaches();
        return coaches.stream()
                .map(Coach::toDTO)
                .toList();
    }

    @PreAuthorize("hasAnyAuthority('ROLE_COACH')")
    @GetMapping(path = "{id}")
    public CoachDTO fetchCoach(@PathVariable("id") UUID id) {
        Coach coach = coachService.getCoach(id);
        return coach.toDTO();
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<String> updateCoach(@RequestBody CoachDTO coachDTO) {
        Coach coach = coachDTO.toModel();
        System.out.println("Coach to be updated: " + coach.toString());
        Coach c = coachService.updateCoach(coach);
        return (c != null) ? ResponseEntity.ok("Success") : ResponseEntity.status(HttpStatus.FORBIDDEN).body("Error");
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<String> deleteCoach(@PathVariable("id") UUID id) {
        coachService.deleteById(id);
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}
