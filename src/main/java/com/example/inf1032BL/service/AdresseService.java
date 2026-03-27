package com.example.inf1032BL.service;

import com.example.inf1032BL.entity.Adresse;
import com.example.inf1032BL.entity.Athlete;

import java.util.List;
import java.util.UUID;

public interface AdresseService {
    boolean existsById(UUID id);
    Adresse createNewAdresse(Adresse adresse);
    /*List<Adresse> getAllAdresses();
    Adresse getAdresse(UUID id);
    Adresse updateAdresse(Adresse adresse);
    void deleteById(UUID id);*/
}
