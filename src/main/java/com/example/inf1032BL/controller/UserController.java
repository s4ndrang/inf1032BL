package com.example.inf1032BL.controller;

import com.example.inf1032BL.entity.Athlete;
import com.example.inf1032BL.entity.Coach;
import com.example.inf1032BL.service.AthleteService;
import com.example.inf1032BL.service.CoachService;
import dto.AthleteDTO;
import dto.CoachDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bl/")
public class UserController {
    private final CoachService coachService;
    private final AthleteService athleteService;

    public UserController(CoachService coachService, AthleteService athleteService) {
        this.coachService = coachService;
        this.athleteService = athleteService;
    }

    @GetMapping(path = "athlete/all")
    public List<AthleteDTO> fetchAllAthletes() {
        List<Athlete> athletes = athleteService.getAllAthletes();
        return athletes.stream()
                .map(Athlete::toDTO)
                .toList();
    }

    @PreAuthorize("hasAnyAuthority('athlete') or hasAnyAuthority('admin')")
    @GetMapping(path = "athlete/{id}")
    public AthleteDTO fetchAthlete(@PathVariable("id") UUID id) {
        Athlete athlete = athleteService.getAthlete(id);
        return athlete.toDTO();
    }
}
