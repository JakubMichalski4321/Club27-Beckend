package com.club27.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public record AuthenticationResponse(String jwt) {
}