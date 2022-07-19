package com.club27.web.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.UUID;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record DeptDto(
        UUID deptId,
        String title,
        Timestamp createdDate,
        Double balance,
        String user1Name,
        String user2Name
) {
}
