package com.club27.web.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import java.util.UUID;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class CommentToUploadDto {

    private String content;
    private String author;
    private UUID memeId;

    public CommentToUploadDto(String content, String author, String memeId) {
        this.content = content;
        this.author = author;
        this.memeId = UUID.fromString(memeId);
    }
}
