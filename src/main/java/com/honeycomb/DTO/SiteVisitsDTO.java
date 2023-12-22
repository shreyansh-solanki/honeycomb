package com.honeycomb.DTO;

import com.honeycomb.Entity.IpAddress;
import com.honeycomb.Entity.User;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class SiteVisitsDTO {

    private Long id;

//    @JsonIgnore
    private User user;

//    @JsonIgnore
    private IpAddress ipAddress;

    private Instant visitStart;

    private Instant visitLastInteraction;

    private String referralUrl;

    // Getters, setters, and other essential methods
}
