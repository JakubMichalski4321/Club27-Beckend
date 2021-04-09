package com.club27.web.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class MemToUploadDto{

    private String title;
    private String author;
    private String imagePath;

    public MemToUploadDto(String title, String author, String imagePath) {
        this.title = title;
        this.author = author;
        this.imagePath = imagePath;
    }
}
