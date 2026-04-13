package com.example.inf1032BL.service;

import com.example.inf1032BL.entity.Coach;
import com.example.inf1032BL.entity.Photo;
import tools.jackson.databind.deser.jdk.UUIDDeserializer;

import java.util.List;
import java.util.UUID;

public interface PhotoService {
    List<Photo> getAllPhotosByTrainingId(UUID id);
    Photo createPhoto(Photo photo);
    void deleteByUrl(String url);
}
