package com.club27.web.dto;

import lombok.Getter;

import java.util.List;

@Getter
public record PajacyzmsWithCounterDto(
        List<PajacyzmDto> pajacyzmy,
        long counter
) {
}
