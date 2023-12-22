package com.honeycomb.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class PasswordHistoryDTO {

    private Long id;

    private String hashedPassword;

    private Instant changeDate;

    private PasswordDTO password;
}
