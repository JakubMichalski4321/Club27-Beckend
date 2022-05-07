package com.club27.web.dto;

import java.sql.Timestamp;
import java.util.UUID;


public record PajacyzmDto(
        UUID id,
        String content,
        String author,
        Timestamp createdDate
) {
}

