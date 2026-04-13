package dto;

import com.example.inf1032BL.entity.Coach;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PhotoDTO {
    UUID id;
    UUID trainingId;
    UUID userId;
    String url;
    Double dateCreated;
}