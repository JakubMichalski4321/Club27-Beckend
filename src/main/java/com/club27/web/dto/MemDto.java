package com.club27.web.dto;

import lombok.Getter;

import java.sql.Timestamp;
import java.util.UUID;
@Getter
public record MemDto(
        UUID id,
        String title,
        String author,
        String imagePath,
        int memeLikes,
        Timestamp createdDate
) {
}
