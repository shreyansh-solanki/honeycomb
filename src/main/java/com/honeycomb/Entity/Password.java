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
@Table(name = "passwords")
public class Password {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passId;

    @OneToOne(mappedBy = "password")
    private User user;

    // Do not store plain password, only the hash
    @Column(nullable = false)
    private String hashedPassword;

    @Column(nullable = false)
    private boolean resetInProgress;

    @Column(nullable = true)
    private Instant resetExpires;

    @Column(nullable = true)
    private String resetCode;

    @Column(nullable = false)
    private boolean isActive;

    // Getters, setters, and other essential methods

}
