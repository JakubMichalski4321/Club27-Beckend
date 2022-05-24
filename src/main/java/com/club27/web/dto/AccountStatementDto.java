package com.club27.web.dto;

import lombok.Getter;

import java.sql.Timestamp;
import java.util.UUID;
@Getter
public record AccountStatementDto(
        UUID accountStatementId,
        Timestamp createdDate,
        String title,
        String desc,
        UUID deptId
) {
}
