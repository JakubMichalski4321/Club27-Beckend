package com.club27.web.dto;

import java.sql.Timestamp;
import java.util.UUID;

public record MemDto(
        UUID id,
        String title,
        String author,
        String imagePath,
        int memeLikes,
        Timestamp createdDate
){ }
