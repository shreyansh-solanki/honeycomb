package com.honeycomb.Responses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponse {

    private String token;

    private String tokenType;

    @JsonIgnore
    private String refreshToken;
}
