package com.honeycomb.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class CartDTO {

    private String uid;
    private Map<String, Double> cartItems;
}
