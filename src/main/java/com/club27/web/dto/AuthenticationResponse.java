package com.club27.web.dto;

import lombok.*;

@Getter
@AllArgsConstructor
public record AuthenticationResponse(String jwt) { }