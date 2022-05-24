package com.club27.web.dto;

import lombok.Getter;

import java.sql.Timestamp;
import java.util.UUID;
@Getter
public record DeptDto(
        UUID deptId,
        Timestamp createdDate,
        Double balance,
        UUID user1,
        UUID user2
) {
}
