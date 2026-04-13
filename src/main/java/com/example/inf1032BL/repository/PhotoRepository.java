package com.example.inf1032BL.repository;

import com.example.inf1032BL.entity.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface PhotoRepository extends MongoRepository<Photo, UUID> {
    void deleteByUrl(String url);
}

//String savePhoto(UUID id, MultipartFile file);

//Méthodes déjà fournis par CrudRepository
//save()/saveAll()
//findById()
//existsById()
//findAll()
//count()
//delete()
//deleteAll()