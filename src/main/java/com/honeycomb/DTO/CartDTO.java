package com.honeycomb.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CartDTO {

    private String id;
    private Set<String> cartItems;
}
