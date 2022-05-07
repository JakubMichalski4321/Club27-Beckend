package com.club27.web.dto;

import java.sql.Timestamp;

public record CommentDto (
        String content,
        String author,
        Timestamp createdDate
){ }
