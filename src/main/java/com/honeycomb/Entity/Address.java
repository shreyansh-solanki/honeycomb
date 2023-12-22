package com.honeycomb.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "addresses")
public class Address {

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

    @Column(nullable = false)
    private String houseNo;

    @Column(nullable = false)
    private String street;

    @Column(nullable = true)
    private String line1;

    @Column(nullable = true)
    private String line2;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private Integer postalCode;

    @Column(nullable = false)
    private boolean isActive;

    // Getters, setters, and other essential methods

}
