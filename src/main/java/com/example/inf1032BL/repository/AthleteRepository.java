package com.example.inf1032BL.repository;

import com.example.inf1032BL.entity.Athlete;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.UUID;

public interface AthleteRepository extends MongoRepository<Athlete, UUID> {
}
