package com.club27.web.dto;

import lombok.Getter;

import java.sql.Timestamp;
import java.util.UUID;
@Getter
public record SoundboardDto(
        UUID id,
        String title,
        String whoIs,
        String pathToFile,
        Timestamp createdDate
) {
}
