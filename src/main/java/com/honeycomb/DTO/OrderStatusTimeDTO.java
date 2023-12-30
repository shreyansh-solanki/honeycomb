package com.honeycomb.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
public class OrderStatusTimeDTO {
    private Long id;

    private Instant orderStatusAt;

    private List<OrderStatusDTO> orderStatuses;
}
