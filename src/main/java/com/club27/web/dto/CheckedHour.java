package com.club27.web.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record CheckedHour(
        String id,
        int day,
        int hour
) {
}
