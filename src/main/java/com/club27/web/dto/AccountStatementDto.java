package com.club27.web.dto;

import java.sql.Timestamp;
import java.util.UUID;

public record AccountStatementDto(
        UUID accountStatementId,
        Timestamp createdDate,
        String title,
        String desc,
        UUID deptId
) {
}
