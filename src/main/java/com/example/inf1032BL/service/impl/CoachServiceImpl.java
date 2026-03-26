package com.example.inf1032BL.service.impl;

import com.example.inf1032BL.entity.Coach;
import com.example.inf1032BL.repository.CoachRepository;
import com.example.inf1032BL.service.CoachService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CoachServiceImpl implements CoachService {
    private final CoachRepository coachRepository;

    public CoachServiceImpl(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    @Override
    public Coach getCoach(UUID id) {
        Optional<Coach> coach = coachRepository.findById(id);
        return coach.orElse(null);
    }

    @Override
    public List<Coach> getAllCoaches() {
        return coachRepository.findAll();
    }

    @Override
    public Coach createNewCoach(Coach coach) {
       return coachRepository.save(coach);
    }

    @Override
    public Coach updateCoach(Coach coach) {
        return coachRepository.save(coach);
    }
    /* @Override
    @Transactional
    public void update(String id, Patient updatedPatient) {
        patientRepository.findById(id).orElseThrow(() -> new IllegalStateException("Patient " + id + " n'existe pas"));
        patientRepository.save(updatedPatient);
    }*/

    @Override
    public void deleteById(UUID id) {
        coachRepository.deleteById(id);
    }
}
