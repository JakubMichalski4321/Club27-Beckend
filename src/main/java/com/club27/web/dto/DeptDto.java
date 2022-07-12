package com.club27.web.dto;

import lombok.Getter;

import java.sql.Timestamp;
import java.util.UUID;
@Getter
public record DeptDto(
        UUID deptId,
        String title,
        Timestamp createdDate,
        Double balance,
        String user1Name,
        String user2Name
) {
}
