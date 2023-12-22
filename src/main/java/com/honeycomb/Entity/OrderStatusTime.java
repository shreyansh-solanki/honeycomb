package com.honeycomb.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_statuses_time")
public class OrderStatusTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant orderStatusAt;

    @OneToMany(mappedBy = "orderStatusTime", cascade = CascadeType.ALL)
    private List<OrderStatus> orderStatuses = new ArrayList<>();
}
