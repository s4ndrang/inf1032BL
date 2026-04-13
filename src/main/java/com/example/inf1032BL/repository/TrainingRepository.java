package com.example.inf1032BL.repository;

import com.example.inf1032BL.entity.Training;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface TrainingRepository extends MongoRepository<Training, UUID> {
}