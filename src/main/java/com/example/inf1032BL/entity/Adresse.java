package com.example.inf1032BL.entity;

import dto.AdresseDTO;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

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
    private String name;
    private String adresse;
    private Double latitude;
    private Double longitude;

    public AdresseDTO toDTO() {
        return new AdresseDTO(
                this.id.toString(),
                this.name,
                this.adresse,
                this.latitude,
                this.longitude
        );
    }
}
