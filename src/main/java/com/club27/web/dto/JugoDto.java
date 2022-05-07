package com.club27.web.dto;

import java.sql.Timestamp;
import java.util.UUID;

public record JugoDto(
        UUID id,
        String title,
        String videoURL,
        String videoComment,
        int videoLikes,
        Timestamp createdDate
) {
}
