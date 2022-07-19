package com.club27.web.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record AuthenticationResponse(String jwt) {
}