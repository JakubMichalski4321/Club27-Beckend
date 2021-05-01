package com.club27.web.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import java.sql.Timestamp;
import java.util.UUID;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class CommentDto {

    private String content;
    private String author;
    private UUID memeId;
    private Timestamp createdDate;

    public CommentDto(String content, String author, Timestamp createdDate) {
        this.content = content;
        this.author = author;
        this.createdDate = createdDate;
    }
}
