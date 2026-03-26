package com.example.inf1032BL.service.impl;

import com.example.inf1032BL.entity.Athlete;
import com.example.inf1032BL.repository.AthleteRepository;
import com.example.inf1032BL.service.AthleteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AthleteServiceImpl implements AthleteService {
    private final AthleteRepository athleteRepository;

    public AthleteServiceImpl(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }

    @Override
    public Athlete getAthlete(UUID id) {
        Optional<Athlete> athlete = athleteRepository.findById(id);
        return athlete.orElse(null);
    }

    @Override
    public List<Athlete> getAllAthletes() {
        return athleteRepository.findAll();
    }
}
