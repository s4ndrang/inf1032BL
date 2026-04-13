package com.example.inf1032BL.controller;

import com.example.inf1032BL.entity.Photo;
import com.example.inf1032BL.entity.Training;
import com.example.inf1032BL.service.PhotoService;
import com.example.inf1032BL.service.StorageService;
import com.example.inf1032BL.service.TrainingService;
import com.google.type.DateTime;
import dto.PhotoDTO;
import dto.TrainingDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bl/photo/")
public class PhotoController {
    private final PhotoService photoService;
    private final StorageService storageService;

    public PhotoController(PhotoService photoService, StorageService storageService) {
        this.photoService = photoService;
        this.storageService = storageService;
    }

    @PostMapping(path = "{trainingId}/{userId}", consumes = "multipart/form-data")
    public ResponseEntity<PhotoDTO> createPhoto(
            @RequestParam("file") MultipartFile file,
            @PathVariable("trainingId") UUID trainingId,
             @PathVariable("userId") UUID userId
    ) throws IOException {
        System.out.println("Coach is trying to create a photo: ");
        System.out.println("FOR: " + trainingId.toString());
        System.out.println("BY: " + userId.toString());
        System.out.println("BODY: " + file);

        String original = file.getOriginalFilename();
        String extension = original != null && original.contains(".")
                ? original.substring(original.lastIndexOf("."))
                : ".jpg";

        UUID photoId = UUID.randomUUID();
        String safeFilename = photoId + extension;

        // Upload to firebase storage and return photo url
        String url = storageService.upload(
                file.getInputStream(),
                safeFilename,
                file.getContentType()
        );
        System.out.println("URL: " + url);
        Photo photo = new Photo(photoId, trainingId, userId, safeFilename, url, (double) Instant.now().getEpochSecond());
        System.out.println("photo: " + photo.toString());
        try {
            Photo savedPhoto = photoService.createPhoto(photo);
            return ResponseEntity.ok(savedPhoto.toDTO());
        } catch (Exception e) {
            // rollback firebaseStorage if db createPhoto fails
            storageService.delete(safeFilename);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @DeleteMapping(path = "{url}")
    public ResponseEntity<String> deletePhoto(@PathVariable("url") String url) {
        System.out.println("Photo to be deleted: " + url.toString());
        photoService.deleteByUrl(url);
        return ResponseEntity.ok("Success");
    }
}

//    @GetMapping(path = "{url}")
//    public PhotoDTO fetchPhoto(@PathVariable("url") String url) {
//        Photo photo = photoService.getPhoto(url);
//        return photo.toDTO();
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
