package com.example.inf1032BL.service.impl;

import com.example.inf1032BL.entity.Adresse;
import com.example.inf1032BL.repository.AdresseRepository;
import com.example.inf1032BL.service.AdresseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AdresseServiceImpl implements AdresseService {
    private final AdresseRepository adresseRepository;

    public AdresseServiceImpl( AdresseRepository adresseRepository) {
        this.adresseRepository = adresseRepository;
    }

    @Override
    public boolean existsById(UUID id) {
        return adresseRepository.existsById(id);
    }

    @Override
    public Adresse createNewAdresse(Adresse adresse) {
        return adresseRepository.save(adresse);
    }

    @Override
    public List<Adresse> getAllAdresses() {
        return adresseRepository.findAll();
    }
}
