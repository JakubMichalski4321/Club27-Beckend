package com.club27.web.dto;

import lombok.Getter;
import java.util.UUID;

@Getter
public record DeptUserDto(
        UUID id,
        String username
) {
}
