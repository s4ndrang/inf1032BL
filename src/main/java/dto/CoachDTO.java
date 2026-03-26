package dto;

import com.example.inf1032BL.entity.Coach;
import lombok.*;

import java.util.UUID;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CoachDTO {
    String id;
    String username;
    String nom;
    String prenom;
    String email;
    String tel;
    String sexe;
    String dateDebut;

    public Coach toModel() {
        Coach coach = new Coach();
        coach.setId(UUID.fromString(this.getId()));
        coach.setUsername(this.getUsername());
        coach.setNom(this.getNom());
        coach.setPrenom(this.getPrenom());
        coach.setEmail(this.getEmail());
        coach.setTel(this.getTel());
        coach.setSexe(this.getSexe());
        coach.setDateDebut(this.getDateDebut());
        return coach;
    }
}
