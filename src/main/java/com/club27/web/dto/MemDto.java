package com.club27.web.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import java.sql.Timestamp;
import java.util.UUID;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class MemDto{

    private UUID id;
    private String title;
    private String author;
    private String imagePath;
    private int memeLikes;
    private Timestamp createdDate;

    public MemDto(UUID id, String title, String author, String imagePath, int memeLikes, Timestamp createdDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.imagePath = imagePath;
        this.memeLikes = memeLikes;
        this.createdDate = createdDate;
    }
}
