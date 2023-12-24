package com.honeycomb.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

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
    private Long id;

    @Column(nullable = false)
    private String fname;

    @Column(nullable = false)
    private String lname;

    @Column(unique = true, nullable = false)
    private String email;

    // Use a secure hashing algorithm instead of storing plain password
    // Consider using a dedicated library like BCryptPasswordEncoder
    // @Column(nullable = false)
    // private String password;

//    @Column(nullable = false)
//    @ManyToMany(cascade = CascadeType.ALL)
//    private IpAddress ipAddress;

    @Column(unique = true, nullable = false)
    private Long primaryPhone;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean isVerified;

    @Column(nullable = false)
    @CreationTimestamp(source = SourceType.DB)
    private Instant createdAt;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "password_id")
//    private Password password;
    @OneToOne
    @JoinColumn(name = "password_id")
//    @JsonBackReference
    private Password password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<LoginHistory> loginHistories = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "wishlist_id")
//    @JsonBackReference
    private Wishlist wishlist;

    @OneToOne
    @JoinColumn(name = "cart_id")
//    @JsonBackReference
    private Cart cart;
}
