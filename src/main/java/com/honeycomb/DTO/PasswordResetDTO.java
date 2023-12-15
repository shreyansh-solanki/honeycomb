package com.honeycomb.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordResetDTO {

    private String id;
    private String resetPasswordLink;
    private Integer resetCode;

    @JsonIgnore
    private PasswordDTO password;
}
