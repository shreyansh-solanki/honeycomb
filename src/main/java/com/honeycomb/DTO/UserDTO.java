package com.honeycomb.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
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

//    @JsonIgnore
    private PasswordDTO password;

//    @JsonIgnore
    private List<AddressDTO> addresses;

//    @JsonIgnore
    private List<LoginHistoryDTO> loginHistories;

//    @JsonIgnore
    private List<OrderDTO> orders;

//    @JsonIgnore
    private WishlistDTO wishlist;

//    @JsonIgnore
    private CartDTO cart;

    // Getters, setters, and other essential methods
}
