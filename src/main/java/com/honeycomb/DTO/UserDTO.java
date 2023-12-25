package com.honeycomb.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.honeycomb.Entity.Authority;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class UserDTO {

    private String id;

    private String fname;

    private String lname;

    private String email;

    private Long primaryPhone;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private boolean isVerified;

    private Instant createdAt;

//    @JsonIgnore
    private Set<AuthorityDTO> authorities;

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

    private PasswordResetDTO passwordReset;

    // Getters, setters, and other essential methods
}
