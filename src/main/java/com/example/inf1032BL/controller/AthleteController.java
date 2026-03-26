package com.example.inf1032BL.controller;

import com.example.inf1032BL.entity.Athlete;
import com.example.inf1032BL.entity.Athlete;
import com.example.inf1032BL.service.AthleteService;
import com.example.inf1032BL.service.AthleteService;
import dto.AthleteDTO;
import dto.AthleteDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bl/athlete/")
public class AthleteController {
    private final AthleteService athleteService;

    public AthleteController(AthleteService athleteService) {
        this.athleteService = athleteService;
    }

    @PostMapping(path = "create-account", produces="application/json")
    public ResponseEntity<String> createAthlete(@RequestBody AthleteDTO athleteDTO) {
        Athlete savedAthlete = athleteService.createNewAthlete(athleteDTO.toModel());
        return savedAthlete != null?  ResponseEntity
                .ok("Success") :
                ResponseEntity
                        .status(HttpStatus.FORBIDDEN)
                        .body("Error");
    }

    @GetMapping(path = "all")
    public List<AthleteDTO> fetchAllAthletes() {
        List<Athlete> athletees = athleteService.getAllAthletes();
        return athletees.stream()
                .map(Athlete::toDTO)
                .toList();
    }

    @PreAuthorize("hasAnyAuthority('athlete') or hasAnyAuthority('admin')")
    @GetMapping(path = "{id}")
    public AthleteDTO fetchAthlete(@PathVariable("id") UUID id) {
        Athlete athlete = athleteService.getAthlete(id);
        return athlete.toDTO();
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<String> updateAthlete(@RequestBody AthleteDTO athleteDTO) {
        Athlete athlete = athleteDTO.toModel();
        System.out.println("Athlete to be updated: " + athlete.toString());
        Athlete c = athleteService.updateAthlete(athlete);
        return (c != null) ? ResponseEntity.ok("Success") : ResponseEntity.status(HttpStatus.FORBIDDEN).body("Error");
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<String> deleteAthlete(@PathVariable("id") UUID id) {
        athleteService.deleteById(id);
        return ResponseEntity.ok("Success");
    }
}
