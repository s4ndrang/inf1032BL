package dto;

import com.example.inf1032BL.entity.Athlete;
import com.example.inf1032BL.entity.Athlete;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AthleteDTO {
    String id;
    String username;
    String nom;
    String prenom;
    String email;
    String tel;
    String sexe;
    Double dateDebut;
    Double dateNaiss;
    String coachId;

    public Athlete toModel() {
        Athlete athlete = new Athlete();
        athlete.setId(UUID.fromString(this.getId()));
        athlete.setUsername(this.getUsername());
        athlete.setNom(this.getNom());
        athlete.setPrenom(this.getPrenom());
        athlete.setEmail(this.getEmail());
        athlete.setTel(this.getTel());
        athlete.setSexe(this.getSexe());
        athlete.setDateDebut(this.getDateDebut());
        athlete.setDateNaiss(this.getDateNaiss());
        athlete.setCoachId(UUID.fromString(this.getCoachId()));
        return athlete;
    }
}
