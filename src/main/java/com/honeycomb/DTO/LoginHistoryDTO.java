package com.honeycomb.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class LoginHistoryDTO {

    private Long id;

    private UserDTO user;

    private Instant attemptedAt;

    private boolean isSuccessful;
}
