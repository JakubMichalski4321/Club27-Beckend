package com.club27.web.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import java.sql.Timestamp;
import java.util.UUID;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class SoundboardDto {

    private UUID id;
    private String title;
    private String whoIs;
    private String pathToFile;
    private Timestamp createdDate;

    public SoundboardDto(UUID id, String title, String whoIs, String pathToFile, Timestamp createdDate) {
        this.id = id;
        this.title = title;
        this.whoIs = whoIs;
        this.pathToFile = pathToFile;
        this.createdDate = createdDate;
    }
}
