package com.club27.web.dto;

import lombok.Getter;

import java.sql.Timestamp;
@Getter
public record CommentDto(
        String content,
        String author,
        Timestamp createdDate
) {
}
