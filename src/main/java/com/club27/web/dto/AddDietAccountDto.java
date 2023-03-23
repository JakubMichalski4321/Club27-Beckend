package com.club27.web.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record AddDietAccountDto (
        @NotEmpty
        String dietName,
        @NotNull
        @Min(0)
        Double currentWeight,
        @NotNull
        @Min(140)
        @Max(250)
        Double currentHeight,
        @NotEmpty
        String userAccountId
) {
}
