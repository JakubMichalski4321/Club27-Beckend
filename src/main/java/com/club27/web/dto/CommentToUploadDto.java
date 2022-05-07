package com.club27.web.dto;

import java.util.UUID;

public record CommentToUploadDto(
        String content,
        String author,
        UUID memeId
) {
}
