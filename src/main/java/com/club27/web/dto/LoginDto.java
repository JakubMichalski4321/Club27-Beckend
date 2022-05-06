package com.club27.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public record LoginDto(
        @NotBlank(message = "Username cannot be null or empty")
        @Size(min = 1,max = 30, message = "Username length must be between 1 and 30")
        String username,

        @NotBlank(message = "Password cannot be null or empty")
        @Size(min = 1,max = 100, message = "Username length must be between 1 and 100")
        String password
) {
}
