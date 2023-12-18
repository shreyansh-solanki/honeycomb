package com.honeycomb.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class IpAddressDTO {

    private String id;
    private String ip1;
    private String ip2;
    private String ip3;
    private String ip4;
    private Instant lastUsed;

    // Getters, setters, and other essential methods
}
