package com.club27.web.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import java.sql.Timestamp;
import java.util.UUID;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class JugoDto {

    private UUID id;
    private String title;
    private String videoURL;
    private String videoComment;
    private int videoLikes;
    private Timestamp createdDate;

    public JugoDto(UUID id, String title, String videoURL, String videoComment, int videoLikes, Timestamp createdDate) {
        this.id = id;
        this.title = title;
        this.videoURL = videoURL;
        this.videoComment = videoComment;
        this.videoLikes = videoLikes;
        this.createdDate = createdDate;
    }
}
