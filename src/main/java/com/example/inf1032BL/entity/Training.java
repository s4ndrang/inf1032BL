package com.example.inf1032BL.entity;

import dto.TrainingDTO;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "training")
public class Training {
    private UUID id;
    private String nom;
    private String date;
    private Adresse lieu;
    private String duree;
    private String coachId;
    private String commentaires;
    private boolean isArchived;
    private List<UUID> presentIds;
    private List<UUID> absentIds;

    public TrainingDTO toDTO() {
        return new TrainingDTO(
                this.id.toString(),
                this.nom,
                this.date,
                this.lieu.toDTO(),
                this.duree,
                this.coachId,
                this.commentaires,
                this.isArchived,
                this.presentIds.stream().map(UUID::toString).toList(),
                this.absentIds.stream().map(UUID::toString).toList()
        );
    }
}