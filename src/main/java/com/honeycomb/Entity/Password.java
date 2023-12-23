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
    private Long id;

    // Do not store plain password, only the hash
    @Column(nullable = false)
    private String hashedPassword;

    @Column(nullable = false)
    private boolean isActive;

    @Column(nullable = false)
    private Instant createdAt;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    @OneToOne(mappedBy = "password", cascade = CascadeType.ALL)
    private PasswordHistory passwordHistory;

    @OneToOne(mappedBy = "password", cascade = CascadeType.ALL)
    private PasswordReset passwordReset;

    // Getters, setters, and other essential methods

}
