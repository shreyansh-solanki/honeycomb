package com.honeycomb.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorityDTO {
    @Id
    private String id;

    private String authority;

    @JsonIgnore
    private UserDTO user;
}
