package com.club27.web.dto;

import java.io.File;
public record MemToUploadImageDto(
        String title,
        String author,
        File image
){ }
