package com.club27.web.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

import java.sql.Timestamp;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class SoundboardDto {

    private String title;
    private String whoIs;
    private String pathToFile;
    private Timestamp createdDate;

    public SoundboardDto(String title, String whoIs, String pathToFile, Timestamp createdDate) {
        this.title = title;
        this.whoIs = whoIs;
        this.pathToFile = pathToFile;
        this.createdDate = createdDate;
    }
}
