package com.club27.web.dto;

public record PageListRequestDto(
        Long pageNumber,
        Long numberPerPage
) { }
