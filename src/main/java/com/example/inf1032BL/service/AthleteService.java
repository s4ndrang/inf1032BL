package com.example.inf1032BL.service;

import com.example.inf1032BL.entity.Athlete;
import com.example.inf1032BL.entity.Coach;

import java.util.List;
import java.util.UUID;

public interface AthleteService {
    List<Athlete> getAllAthletes();
    Athlete getAthlete(UUID id);
    Athlete createNewAthlete(Athlete athlete);
    Athlete updateAthlete(Athlete athlete);
    void deleteById(UUID id);
}
