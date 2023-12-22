package com.honeycomb.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class PasswordResetDTO {

    private Long id;

    private String resetToken;

    private Instant requestTime;

    private PasswordDTO password;
}
