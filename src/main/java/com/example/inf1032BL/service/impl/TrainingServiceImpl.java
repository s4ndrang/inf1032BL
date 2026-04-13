package com.example.inf1032BL.service.impl;

import com.example.inf1032BL.entity.Training;
import com.example.inf1032BL.repository.TrainingRepository;
import com.example.inf1032BL.service.TrainingService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TrainingServiceImpl implements TrainingService {
    private final TrainingRepository trainingRepository;

    public TrainingServiceImpl(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    @Override
    public Training getTraining(UUID id) {
        Optional<Training> training = trainingRepository.findById(id);
        return training.orElse(null);
    }

    @Override
    public List<Training> getAllTraininges() {
        return trainingRepository.findAll();
    }

    @Override
    public Training createNewTraining(Training training) {
        return trainingRepository.save(training);
    }

    @Override
    public Training updateTraining(Training training) {
        return trainingRepository.save(training);
    }

    @Override
    public void deleteById(UUID id) {
        trainingRepository.deleteById(id);
    }

//    @Override
//    public String savePhoto(UUID id, MultipartFile file) {
//        return photoRepository.savePhoto(id, file);
//    }
}