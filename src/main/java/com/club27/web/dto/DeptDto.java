package com.club27.web.dto;

import java.sql.Timestamp;
import java.util.UUID;

public record DeptDto(
        UUID deptId,
        Timestamp createdDate,
        Double balance,
        UUID user1,
        UUID user2
) {
}
