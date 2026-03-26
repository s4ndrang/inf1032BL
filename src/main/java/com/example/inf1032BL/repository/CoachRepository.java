package com.example.inf1032BL.repository;

import com.example.inf1032BL.entity.Coach;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.UUID;

public interface CoachRepository extends MongoRepository<Coach, UUID> {
}

//Méthodes déjà fournis par CrudRepository
//save()/saveAll()
//findById()
//existsById() TODO
//findAll()
//count()
//delete()
//deleteAll()