package com.club27.web.dto;

import com.club27.domain.Comment;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record MemDto(
        UUID id,
        String title,
        String author,
        String imagePath,
        int memeLikes,
        Timestamp createdDate,
        List<CommentDto> memeComments
) {
}
