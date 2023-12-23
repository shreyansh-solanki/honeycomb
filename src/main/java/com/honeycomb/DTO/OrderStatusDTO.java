package com.honeycomb.DTO;

import com.honeycomb.Entity.Order;
import com.honeycomb.Entity.OrderStatusTime;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderStatusDTO {
    private Long id;

    private OrderDTO order;

    private OrderStatusTimeDTO orderStatusTime;

    private String statusCode;

    private String description;
}
