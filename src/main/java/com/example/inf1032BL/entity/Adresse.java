package com.example.inf1032BL.entity;

import dto.AdresseDTO;
import dto.AthleteDTO;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.security.PrivateKey;
import java.util.UUID;

@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "adresse")
public class Adresse {
    private UUID id;
    private String numero;
    private String rue;
    private String numeroApt;
    private String ville;
    private String province;
    private String pays;
    private String cp;

    public AdresseDTO toDTO() {
        return new AdresseDTO(
                this.id.toString(),
                this.numero,
                this.rue,
                this.numeroApt,
                this.ville,
                this.province,
                this.pays,
                this.cp
        );
    }
}
