package com.example.inf1032BL.service;

import com.example.inf1032BL.entity.Coach;
import dto.CoachDTO;

import java.util.List;
import java.util.UUID;

public interface CoachService {
    List<Coach> getAllCoaches();
    Coach getCoach(UUID id);
    Coach createNewCoach(Coach coach);
    Coach updateCoach(Coach coach);
    void deleteById(UUID id);
}
