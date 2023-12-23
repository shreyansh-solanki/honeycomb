package com.honeycomb.DTO;

import com.honeycomb.Entity.Address;
import com.honeycomb.Entity.Cart;
import com.honeycomb.Entity.Order;
import com.honeycomb.Entity.Wishlist;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserDTO {

    private Long id;

    private String fname;

    private String lname;

    private String email;

    private Long primaryPhone;

    private boolean isVerified;

    private Instant createdAt;

    private PasswordDTO password;

    private List<Address> addresses;

    private List<LoginHistoryDTO> loginHistories;

    private List<OrderDTO> orders;

    private WishlistDTO wishlist;

    private CartDTO cart;

    // Getters, setters, and other essential methods
}
