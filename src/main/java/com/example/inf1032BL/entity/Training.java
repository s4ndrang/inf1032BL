package com.example.inf1032BL.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import dto.TrainingDTO;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "training")
public class Training {
    private UUID id;
    private String nom;
    private Double date;
    private UUID adresseId;
    private int duree;
    private String coachId;
    private String commentaires;
    private boolean isArchived;
    private Map<String, Integer> athletePresenceMap;
    private Map<String, Integer> athleteActualPresenceMap;
    private List<String> photos;

    public TrainingDTO toDTO() {
        return new TrainingDTO(
                this.id.toString(),
                this.nom,
                this.date,
                this.adresseId.toString(),
                this.duree,
                this.coachId,
                this.commentaires,
                this.isArchived,
                this.athletePresenceMap,
                this.athleteActualPresenceMap,
                this.photos
        );
    }
}