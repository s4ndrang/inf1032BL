package com.example.inf1032BL.service;

import com.example.inf1032BL.entity.Training;
import org.springframework.web.multipart.MultipartFile;
import org.yaml.snakeyaml.events.Event;

import java.util.List;
import java.util.UUID;

public interface TrainingService {
    List<Training> getAllTraininges();
    Training getTraining(UUID id);
    Training createNewTraining(Training training);
    Training updateTraining(Training training);
    void deleteById(UUID id);
//    String savePhoto(UUID id, MultipartFile file);
}
