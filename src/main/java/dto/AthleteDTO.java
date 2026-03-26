package dto;

import com.example.inf1032BL.entity.Athlete;

import java.util.UUID;

public class AthleteDTO {
    UUID id;
    String username;
    String nom;
    String prenom;
    String email;
    String tel;
    String sexe;
    String dateNaiss;
    UUID coachId;

    public AthleteDTO(UUID id, String username, String nom, String prenom, String email, String tel, String sexe, String dateNaiss, UUID coachId) {
        this.id = id;
        this.username = username;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
        this.sexe = sexe;
        this.dateNaiss = dateNaiss;
        this.coachId = coachId;
    }

    public Athlete toModel() {
        return new Athlete(
                this.id,
                this.username,
                this.nom,
                this.prenom,
                this.email,
                this.tel,
                this.sexe,
                this.dateNaiss,
                this.coachId
        );
    }
}
