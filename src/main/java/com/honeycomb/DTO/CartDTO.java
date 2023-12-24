package com.honeycomb.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartDTO {

    private String id;

    @JsonIgnore
    private UserDTO user;

    private List<CartItemDTO> cartItems;
}
