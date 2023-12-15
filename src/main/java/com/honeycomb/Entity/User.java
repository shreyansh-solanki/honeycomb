package com.honeycomb.Entity;

import com.honeycomb.Entity.Password;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(nullable = false)
    private String fname;

    @Column(nullable = false)
    private String lname;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private boolean isVerified;

    // Use a secure hashing algorithm instead of storing plain password
    // Consider using a dedicated library like BCryptPasswordEncoder
    // @Column(nullable = false)
    // private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pid")
    private Password password;

    @Column(nullable = false)
    @ManyToMany(cascade = CascadeType.ALL)
    private IpAddress ipAddress;

    @Column(nullable = false)
    private Instant createdAt;

    // Getters, setters, and other essential methods

}
