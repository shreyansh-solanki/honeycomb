package com.honeycomb.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.honeycomb.Entity.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class PricingHistoryDTO {
    @Id
    private Long id;

    @JsonIgnore
    private Product product;

    private Double oldPrice;

    private Double newPrice;

    private Double oldDiscount;

    private Double newDiscount;

    private Instant startPriceDateTime;

    private Instant endPriceDateTime;
}
