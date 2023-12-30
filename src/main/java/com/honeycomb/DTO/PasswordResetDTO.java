package com.honeycomb.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class PasswordResetDTO {

    private String id;

    private String resetToken;

    private Instant requestTime;

    @JsonIgnore
    private UserDTO user;
}
