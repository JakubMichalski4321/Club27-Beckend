package com.club27.web.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.UUID;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record AccountStatementDto(
        UUID accountStatementId,
        Timestamp createdDate,
        String title,
        String desc,
        UUID deptId
) {
}
