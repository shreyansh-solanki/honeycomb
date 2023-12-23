package com.honeycomb.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDTO {

    private Long id;

    private OrderDTO order;

    private ProductDTO product;

    private Integer quantity;

    private Double price;
}
