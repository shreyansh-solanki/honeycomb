package com.honeycomb.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class UserDTO {
    private String uid;
    private Instant createdAt;
    private String fistName;
    private String lastName;
    private String email;
    private Long primaryPhone;
}
