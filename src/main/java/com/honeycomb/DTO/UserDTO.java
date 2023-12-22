package com.honeycomb.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
public class UserDTO {

    private Long id;

    private String fname;

    private String lname;

    private String email;

    private Long primaryPhone;

    private boolean isVerified;

    private Instant createdAt;

    private PasswordDTO password;

    private List<LoginHistoryDTO> loginHistories;

    // Getters, setters, and other essential methods
}
