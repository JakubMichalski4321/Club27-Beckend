package com.club27.web.dto;

import lombok.Data;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
public record PajacyzmDto(
        UUID id,
        String content,
        String author,
        Timestamp createdDate
) {
}

