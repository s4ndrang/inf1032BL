package com.example.inf1032BL.entity;

import dto.CoachDTO;
import dto.PhotoDTO;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.UUID;

@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "photo")
public class Photo {
    UUID id;
    UUID trainingId;
    UUID userId;
    String filename;
    String url;
    Double dateCreated;

    public PhotoDTO toDTO() {
        return new PhotoDTO(
                this.id,
                this.trainingId,
                this.userId,
                this.url,
                this.dateCreated
        );
    }
}
