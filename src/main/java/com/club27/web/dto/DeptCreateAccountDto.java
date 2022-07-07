package com.club27.web.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;
public record DeptCreateAccountDto(
        @NotBlank
        String accountName,
        @NotBlank
        UUID userId,
        @NotNull
        @NotEmpty
        List<String> deptUsersIds
) {
}