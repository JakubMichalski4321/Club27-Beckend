package com.club27.web.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record UserWithCheckedHours(
        List<CheckedHour> checkedHours,
        String username
) {
}
