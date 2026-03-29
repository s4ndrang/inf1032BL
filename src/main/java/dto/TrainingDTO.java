package dto;

import com.example.inf1032BL.entity.Training;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TrainingDTO {
    private String id;
    private String nom;
    private Double date;
    private AdresseDTO lieu;
    private int duree;
    private String coachId;
    private String commentaires;
    @JsonProperty("archived")
    private boolean isArchived;
    private List<String> presentIds;
    private List<String> absentIds;

    public Training toModel() {
        Training training = new Training();
        training.setId(UUID.fromString(this.getId()));
        training.setNom(this.getNom());
        training.setDate(this.getDate());
        training.setLieu(this.getLieu().toModel());
        training.setDuree(this.getDuree());
        training.setCoachId(this.getCoachId());
        training.setCommentaires(this.getCommentaires());
        training.setArchived(this.isArchived());
        training.setPresentIds(this.presentIds.stream().map(UUID::fromString).toList());
        training.setAbsentIds(this.absentIds.stream().map(UUID::fromString).toList());
        return training;
    }
}