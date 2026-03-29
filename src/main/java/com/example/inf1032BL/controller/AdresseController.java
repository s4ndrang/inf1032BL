package com.example.inf1032BL.controller;

import com.example.inf1032BL.entity.Adresse;
import com.example.inf1032BL.entity.Training;
import com.example.inf1032BL.service.AdresseService;
import com.example.inf1032BL.service.TrainingService;
import dto.AdresseDTO;
import dto.TrainingDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bl/adresse/")
public class AdresseController {
    private final AdresseService adresseService;

    public AdresseController(AdresseService adresseService) {
        this.adresseService = adresseService;
    }
    @PostMapping(path = "create", produces="application/json")
    public ResponseEntity<String> createAdresse(@RequestBody AdresseDTO adresseDTO) {
        System.out.println("Adresse to be created: " + adresseDTO.toString());
        Adresse savedAdresse = adresseService.createNewAdresse(adresseDTO.toModel());
        return savedAdresse != null?  ResponseEntity
                .ok("Success") :
                ResponseEntity
                        .status(HttpStatus.FORBIDDEN)
                        .body("Error");
    }

    @GetMapping(path = "all")
    public List<AdresseDTO> fetchAllAdresses() {
        List<Adresse> adresses = adresseService.getAllAdresses();
        return adresses.stream()
                .map(Adresse::toDTO)
                .toList();
    }
}