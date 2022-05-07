package com.club27.web.dto;

import java.sql.Timestamp;
import java.util.UUID;

public record SoundboardDto(
        UUID id,
        String title,
        String whoIs,
        String pathToFile,
        Timestamp createdDate
) { }
