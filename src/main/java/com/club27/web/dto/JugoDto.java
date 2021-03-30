package com.club27.web.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

import java.sql.Timestamp;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class JugoDto {

    private String title;
    private String videoURL;
    private String videoComment;
    private int videoLikes;
    private Timestamp createdDate;

    public JugoDto(String title, String videoURL, String videoComment, int videoLikes, Timestamp createdDate) {
        this.title = title;
        this.videoURL = videoURL;
        this.videoComment = videoComment;
        this.videoLikes = videoLikes;
        this.createdDate = createdDate;
    }
}
