package com.example.inf1032BL.entity;

import dto.CoachDTO;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "coach")
public class Coach {
    UUID id;
    String username;
    String nom;
    String prenom;
    String email;
    String tel;
    String sexe;
    String dateDebut;

    public CoachDTO toDTO() {
        return new CoachDTO(
                this.id.toString(),
                this.username,
                this.nom,
                this.prenom,
                this.email,
                this.tel,
                this.sexe,
                this.dateDebut
        );
    }
}
