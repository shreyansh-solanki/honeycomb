package com.honeycomb.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "wishlists")
public class Wishlist {

    @Id
    private String id;

    @OneToOne(mappedBy = "wishlist", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonManagedReference
    private User user;

    @OneToMany(mappedBy = "wishlist", cascade = CascadeType.ALL)
    private List<WishlistItem> wishlistItems = new ArrayList<>();
}
