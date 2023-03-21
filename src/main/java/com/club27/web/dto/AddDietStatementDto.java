package com.club27.web.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record AddDietStatementDto(
        @NotNull
        @Min(0)
        Double weight,
        String description,
        @NotEmpty
        String dietId
) {
}
