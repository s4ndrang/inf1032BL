package com.example.inf1032BL.controller;

import com.example.inf1032BL.entity.Training;
import com.example.inf1032BL.service.AdresseService;
import com.example.inf1032BL.service.StorageService;
import com.example.inf1032BL.service.TrainingService;
import dto.AdresseDTO;
import dto.TrainingDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bl/training/")
public class TrainingController {
    private final TrainingService trainingService;
    private final StorageService storageService;

    public TrainingController(TrainingService trainingService, StorageService storageService) {
        this.trainingService = trainingService;
        this.storageService = storageService;
    }

    @PostMapping(path = "create", produces="application/json")
    public ResponseEntity<String> createTraining(@RequestBody TrainingDTO trainingDTO) {
        System.out.println("Coach is trying to create training: ");
        System.out.println(trainingDTO.toString());
        Training savedTraining = trainingService.createNewTraining(trainingDTO.toModel());
        return savedTraining != null?  ResponseEntity
                .ok("Success") :
                ResponseEntity
                        .status(HttpStatus.FORBIDDEN)
                        .body("Error");
    }

    //The @Secured annotation is used to specify a list of roles on a method. So, a user only can access that method if she has at least one of the specified roles.
    //@PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping(path = "all")
    public List<TrainingDTO> fetchAllTrainings() {
        List<Training> traininges = trainingService.getAllTraininges();
        return traininges.stream()
                .map(Training::toDTO)
                .toList();
    }

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
        System.out.println("Training to be deleted: " + id.toString());
        trainingService.deleteById(id);
        return ResponseEntity.ok("Success");
    }

//    @PostMapping(path = "photo/{id}", consumes = "multipart/form-data")
//    public ResponseEntity<String> createPhoto(
//            @RequestParam("file") MultipartFile file,
//            @PathVariable("id") UUID id
//    ) throws IOException {
//        System.out.println("Coach is trying to create a photo: ");
//        System.out.println("FOR: " + id.toString());
//        System.out.println("BODY: " + file);
//
//        String original = file.getOriginalFilename();
//        String extension = original != null && original.contains(".")
//                ? original.substring(original.lastIndexOf("."))
//                : ".jpg";
//
//        String safeFilename = UUID.randomUUID() + extension;
//
//        // Upload to storage and return photo url
//        String url = storageService.upload(
//                file.getInputStream(),
//                safeFilename,
//                file.getContentType()
//        );
//
////        storageService.upload(file.getInputStream(), safeFilename);
////        String url = "https://inf1030tp.firebasestorage.app/" + safeFilename;
////        Training savedTraining = trainingService.createNewTraining(trainingDTO.toModel());
//        try {
//            String photoUrl = trainingService.savePhoto(id, file);
//            return ResponseEntity.ok(photoUrl);
//        } catch (Exception e) {
//            return ResponseEntity
//                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Upload failed");
//        }
//    }

    /*@PostMapping(path = "{id}/photo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
 public ResponseEntity<String> uploadPhoto(
         @PathVariable UUID id,
         @RequestParam("file") MultipartFile file
 ) {
     try {
         String photoUrl = trainingService.savePhoto(id, file);
         return ResponseEntity.ok(photoUrl);
     } catch (Exception e) {
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Upload failed");
     }
 }*/
}