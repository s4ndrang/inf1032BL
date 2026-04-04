package dto;

import com.example.inf1032BL.entity.Adresse;
import lombok.*;
import org.springframework.data.javapoet.LordOfTheStrings;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;

import java.util.UUID;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdresseDTO {
    private String id;
    private String name;
    private String adresse;
    private Double latitude;
    private Double longitude;

    public Adresse toModel() {
        return new Adresse(
                UUID.fromString(this.id),
                this.name,
                this.adresse,
                this.latitude,
                this.longitude
        );
    }
}