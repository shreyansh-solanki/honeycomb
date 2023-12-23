package com.honeycomb.DTO;

import com.honeycomb.Entity.OrderItem;
import com.honeycomb.Entity.OrderStatus;
import com.honeycomb.Entity.User;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
public class OrderDTO {

    private Long id;

    private Instant orderDate;

    private Double total;

    private User user;

    private List<OrderItem> orderItems;

    private List<OrderStatus> orderStatuses;
}
