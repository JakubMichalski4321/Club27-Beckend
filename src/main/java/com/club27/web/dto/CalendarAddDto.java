package com.club27.web.dto;

public record CalendarAddDto(
        String username,
        String userId,
        String weekStartDate,
        String weekEndDate,
        int day,
        int hour
) {
}
