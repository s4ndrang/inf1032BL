package dto;

import com.example.inf1032BL.entity.Training;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TrainingDTO {
    private String id;
    private String nom;
    private String date;
    private String lieu;
    private String duree;
    private String coachId;
    private String commentaires;
    private boolean isArchived;
    private List<String> presentIds;
    private List<String> absentIds;

    public Training toModel() {
        Training training = new Training();
        training.setId(UUID.fromString(this.getId()));
        training.setNom(this.getNom());
        training.setDate(this.getDate());
        training.setLieu(this.getLieu());
        training.setDuree(this.getDuree());
        training.setCoachId(this.getCoachId());
        training.setCommentaires(this.getCommentaires());
        training.setArchived(this.isArchived());
        training.setPresentIds(this.presentIds.stream().map(UUID::fromString).toList());
        training.setAbsentIds(this.absentIds.stream().map(UUID::fromString).toList());
        return training;
    }
}