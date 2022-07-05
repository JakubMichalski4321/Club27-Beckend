package com.club27.web.dto;

import lombok.Getter;

import java.util.List;

@Getter
public record MemesWithCounterDto(
        List<MemDto> memes,
        long counter
) {
}
