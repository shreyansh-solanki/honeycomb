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
@Table(name = "ip_addresses")
public class IpAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    private String id;
=======
    private Long id;
>>>>>>> 7010b8e446a10ee628e1279523185d36e7cef3e9

    @Column(nullable = false)
    private String ip1;

    @Column(nullable = true)
    private String ip2;

    @Column(nullable = true)
    private String ip3;

    @Column(nullable = true)
    private String ip4;

    @Column(nullable = false)
    private Instant lastUsed;

    // Getters, setters, and other essential methods

}
