package com.honeycomb.DTO;

import com.honeycomb.Entity.Cart;
import com.honeycomb.Entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemDTO {

    private Long id;

    private Cart cart;

    private String productId;

    private Integer quantity;

    private Double price;
}
