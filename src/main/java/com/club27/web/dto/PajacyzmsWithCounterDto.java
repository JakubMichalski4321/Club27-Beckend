package com.club27.web.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record PajacyzmsWithCounterDto(
        List<PajacyzmDto> pajacyzmy,
        long counter
) {
}
