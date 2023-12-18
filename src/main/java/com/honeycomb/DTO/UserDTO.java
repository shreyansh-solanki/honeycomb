package com.honeycomb.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class UserDTO {

    private String id;
    private String fname;
    private String lname;
    private String email;

    private PasswordDTO password;

    private Long primaryPhone;
    private Instant createdAt;
    private boolean isVerified;

    private IpAddressDTO ipAddress;

    // Getters, setters, and other essential methods
}
