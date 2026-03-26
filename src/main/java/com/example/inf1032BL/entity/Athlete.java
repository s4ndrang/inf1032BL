package com.example.inf1032BL.entity;

import dto.AthleteDTO;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "athlete")
public class Athlete {
    UUID id;
    String username;
    private String nom;
    private String prenom;
    private String email;
    private String tel;
    private String sexe;
    private String dateNaiss;
    private UUID coachId;

    public AthleteDTO toDTO() {
        return new AthleteDTO(
                this.id,
                this.username,
                this.nom,
                this.prenom,
                this.email,
                this.tel,
                this.sexe,
                this.dateNaiss,
                this.coachId
        );
    }
}
