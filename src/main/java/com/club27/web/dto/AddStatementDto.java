package com.club27.web.dto;

import com.club27.domain.UserAccount;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record AddStatementDto(
        @NotNull
        Double amount,
        @NotNull
        String title,
        String description,
        @NotNull
        @NotBlank
        String deptUserId,
        @NotBlank
        @NotNull
        String deptId
) {
}
