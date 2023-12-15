package com.honeycomb.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordHistoryDTO {

    private PasswordDTO password;

    private String hashedPassword;
}
