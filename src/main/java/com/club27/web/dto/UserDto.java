package com.club27.web.dto;

import java.sql.Timestamp;
import java.util.UUID;

public record UserDto(
        UUID userId,
        Timestamp createdDate,
        String name,
        String pass
) { }
