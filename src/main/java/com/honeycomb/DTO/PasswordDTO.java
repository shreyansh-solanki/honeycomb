package com.honeycomb.DTO;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class PasswordDTO {

    private Long id;

    private String hashedPassword;

    private String resetCode;

    private boolean isActive;

    private Instant createdAt;

    private UserDTO user;

    private PasswordHistoryDTO passwordHistory;

    private PasswordResetDTO passwordReset;

    // Getters, setters, and other essential methods
}
