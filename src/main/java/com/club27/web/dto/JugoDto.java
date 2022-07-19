package com.club27.web.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.UUID;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record JugoDto(
        UUID id,
        String title,
        String videoURL,
        String videoComment,
        int videoLikes,
        Timestamp createdDate
) {
}
