package com.honeycomb.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;
import java.util.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User implements UserDetails {

    @Id
    private String id;

    @Column(nullable = false)
    private String fname;

    @Column(nullable = false)
    private String lname;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

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

    @OneToOne
    @JoinColumn(name = "passwordReset_id")
    private PasswordReset passwordReset;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
//    @JsonIgnore
    private Set<Authority> authorities = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getUsername() {
        return this.id;
    }

    @Override
    public String getPassword() {
        // Implement this method to return the password for the user
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
