package com.honeycomb.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class PasswordDTO {

    private String id;

//    Optional to show user in rest api // here not showing the user in api
//    @JsonIgnore
    private UserDTO user;

    @JsonIgnore
    private String hashedPassword;

    private boolean isActive;

    private PasswordResetDTO passwordReset;

    private Instant createdAt;

    // Getters, setters, and other essential methods
}
