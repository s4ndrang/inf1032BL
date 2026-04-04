package dto;

import com.example.inf1032BL.entity.Training;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.security.PrivateKey;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TrainingDTO {
    private String id;
    private String nom;
    private Double date;
    private String adresseId;
    private int duree;
    private String coachId;
    private String commentaires;
    @JsonProperty("archived")
    private boolean isArchived;
    private Map<String, Integer> athletePresenceMap;
    private Map<String, Integer> athleteActualPresenceMap;
    private List<String> photos;

    public Training toModel() {
        Training training = new Training();
        training.setId(UUID.fromString(id));
        training.setNom(nom);
        training.setDate(date);
        training.setAdresseId(UUID.fromString(adresseId));
        training.setDuree(duree);
        training.setCoachId(coachId);
        training.setCommentaires(commentaires);
        training.setArchived(isArchived);
        training.setAthletePresenceMap(athletePresenceMap);
        training.setAthleteActualPresenceMap(athleteActualPresenceMap);
        training.setPhotos(photos);
        return training;
    }
}