package com.club27.web.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;

import java.sql.Timestamp;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record CommentDto(
        String content,
        String author,
        Timestamp createdDate
) {
}
