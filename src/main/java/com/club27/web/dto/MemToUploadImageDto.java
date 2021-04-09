package com.club27.web.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class MemToUploadImageDto{

    private String title;
    private String author;
    private File image;

    public MemToUploadImageDto(String title, String author, File image) {
        this.title = title;
        this.author = author;
        this.image = image;
    }
}
