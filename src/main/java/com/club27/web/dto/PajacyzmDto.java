package com.club27.web.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import java.sql.Timestamp;
import java.util.UUID;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class PajacyzmDto{
    private UUID id;
    private String content;
    private String author;
    private Timestamp createdDate;

    public PajacyzmDto(UUID id, String content, String author, Timestamp createdDate) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.createdDate = createdDate;
    }
}

