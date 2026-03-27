package dto;

import com.example.inf1032BL.entity.Adresse;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdresseDTO {
    private String id;
    private String numero;
    private String rue;
    private String numeroApt;
    private String ville;
    private String province;
    private String pays;
    private String cp;

    public Adresse toModel() {
        return new Adresse(
                UUID.fromString(this.id),
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