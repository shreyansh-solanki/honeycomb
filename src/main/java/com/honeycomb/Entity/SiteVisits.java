package com.honeycomb.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "site_visits")
public class SiteVisits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long svid;

    @ManyToOne
    @JoinColumn(name = "uid")
    private User user;

    @ManyToOne
    @JoinColumn(name = "ipid")
    private IpAddress ipAddress;

    @Column(nullable = false)
    private Instant visitStart;

    @Column(nullable = true)
    private Instant visitLastInteraction;

    @Column(nullable = true)
    private String referralUrl;

    // Getters, setters, and other essential methods

}
