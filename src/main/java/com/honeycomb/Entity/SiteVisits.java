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
<<<<<<< HEAD
    private String id;
=======
    private Long id;
>>>>>>> 7010b8e446a10ee628e1279523185d36e7cef3e9

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "ip_id")
    private IpAddress ipAddress;

    @Column(nullable = false)
    private Instant visitStart;

    @Column(nullable = true)
    private Instant visitLastInteraction;

    @Column(nullable = true)
    private String referralUrl;

    // Getters, setters, and other essential methods

}
