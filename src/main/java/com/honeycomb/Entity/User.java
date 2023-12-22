package com.honeycomb.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    private String id;
=======
    private Long id;
>>>>>>> 7010b8e446a10ee628e1279523185d36e7cef3e9

    @Column(nullable = false)
    private String fname;

    @Column(nullable = false)
    private String lname;

    @Column(unique = true, nullable = false)
    private String email;

<<<<<<< HEAD
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
=======
    @Column(unique = true, nullable = false)
    private Long primaryPhone;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean isVerified;
>>>>>>> 7010b8e446a10ee628e1279523185d36e7cef3e9

    @Column(nullable = false)
    private Instant createdAt;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "password_id")
//    private Password password;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Password password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<LoginHistory> loginHistories = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Wishlist wishlist;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Cart cart;
}
