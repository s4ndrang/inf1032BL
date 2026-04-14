package com.example.inf1032BL.service.impl;

import com.example.inf1032BL.entity.Photo;
import com.example.inf1032BL.repository.PhotoRepository;
import com.example.inf1032BL.service.PhotoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PhotoServiceImpl implements PhotoService {
    private final PhotoRepository photoRepository;

    public PhotoServiceImpl(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Override
    public List<Photo> getAllPhotosByTrainingId(UUID id) {
        List<Photo> allPhotos = photoRepository.findAll();
        return allPhotos.stream().filter(p -> p.getId() == id).collect(Collectors.toList());
    }

    @Override
    public Photo createPhoto(Photo photo) {
        return photoRepository.save(photo);
    }

    @Override
    public void deleteById(UUID id) {
        photoRepository.deleteById(id);
    }

    @Override
    public Photo findById(UUID id) {
        return photoRepository.findById(id).isPresent() ? photoRepository.findById(id).get() : null;
    }

    @Override
    public Photo[] findByTrainingId(UUID id) {
        return photoRepository.findByTrainingId(id);
    }
}