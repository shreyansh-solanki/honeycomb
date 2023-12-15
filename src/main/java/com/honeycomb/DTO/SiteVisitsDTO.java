package com.honeycomb.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.honeycomb.Entity.IpAddress;
import com.honeycomb.Entity.User;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class SiteVisitsDTO {

    private String id;

//    @JsonIgnore
    private User user;

//    @JsonIgnore
    private IpAddress ipAddress;

    private Instant visitStart;

    private Instant visitLastInteraction;

    private String referralUrl;

    // Getters, setters, and other essential methods
}
