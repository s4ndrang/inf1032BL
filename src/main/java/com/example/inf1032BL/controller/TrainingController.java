package com.example.inf1032BL.controller;

import com.example.inf1032BL.entity.Adresse;
import com.example.inf1032BL.entity.Training;
import com.example.inf1032BL.service.AdresseService;
import com.example.inf1032BL.service.TrainingService;
import dto.TrainingDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bl/training/")
public class TrainingController {
    private final TrainingService trainingService;
    private final AdresseService adresseService;

    public TrainingController(TrainingService trainingService,  AdresseService adresseService) {
        this.trainingService = trainingService;
        this.adresseService = adresseService;
    }
    @PostMapping(path = "create", produces="application/json")
    public ResponseEntity<String> createTraining(@RequestBody TrainingDTO trainingDTO) {
        System.out.println("Training to be created: " + trainingDTO.toString());
        Training training = trainingDTO.toModel();
        if (!isAdresseExist(training.getLieu().getId())) {
            adresseService.createNewAdresse(training.getLieu());
        }
        Training savedTraining = trainingService.createNewTraining(trainingDTO.toModel());
        return savedTraining != null?  ResponseEntity
                .ok("Success") :
                ResponseEntity
                        .status(HttpStatus.FORBIDDEN)
                        .body("Error");
    }

    private boolean isAdresseExist(UUID id) {
        return adresseService.existsById(id);
    }

    //The @Secured annotation is used to specify a list of roles on a method. So, a user only can access that method if she has at least one of the specified roles.
    //@PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping(path = "all")
    public List<TrainingDTO> fetchAllTraininges() {
        List<Training> traininges = trainingService.getAllTraininges();
        return traininges.stream()
                .map(Training::toDTO)
                .toList();
    }

    @PreAuthorize("hasAnyAuthority('training') or hasAnyAuthority('admin')")
    @GetMapping(path = "{id}")
    public TrainingDTO fetchTraining(@PathVariable("id") UUID id) {
        Training training = trainingService.getTraining(id);
        return training.toDTO();
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<String> updateTraining(@RequestBody TrainingDTO trainingDTO) {
        Training training = trainingDTO.toModel();
        System.out.println("Training to be updated: " + training.toString());
        Training c = trainingService.updateTraining(training);
        return (c != null) ? ResponseEntity.ok("Success") : ResponseEntity.status(HttpStatus.FORBIDDEN).body("Error");
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<String> deleteTraining(@PathVariable("id") UUID id) {
        trainingService.deleteById(id);
        return ResponseEntity.ok("Success");
    }
}