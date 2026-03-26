package com.example.inf1032BL.service;

import com.example.inf1032BL.entity.Athlete;

import java.util.List;
import java.util.UUID;

public interface AthleteService {
    List<Athlete> getAllAthletes();
    Athlete getAthlete(UUID id);
}
