package com.club27.web.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.UUID;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record PajacyzmDto(
        UUID id,
        String content,
        String author,
        Timestamp createdDate
) {
}

