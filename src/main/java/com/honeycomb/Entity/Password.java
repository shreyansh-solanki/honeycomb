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
<<<<<<< HEAD
    private String id;

    @OneToOne(mappedBy = "password")
    private User user;
=======
    private Long id;
>>>>>>> 7010b8e446a10ee628e1279523185d36e7cef3e9

    // Do not store plain password, only the hash
    @Column(nullable = false)
    private String hashedPassword;

<<<<<<< HEAD
//    @Column(nullable = false)
//    private boolean resetInProgress;
//
//    @Column(nullable = true)
//    private Instant resetExpires;
//
//    @Column(nullable = true)
//    private String resetCode;
=======
    @Column(nullable = true)
    private String resetCode;
>>>>>>> 7010b8e446a10ee628e1279523185d36e7cef3e9

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
