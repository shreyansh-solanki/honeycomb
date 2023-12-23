package com.honeycomb.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class PricingHistoryDTO {
    private Long id;

    private ProductDTO product;

    private Double oldPrice;

    private Double newPrice;

    private Double oldDiscount;

    private Double newDiscount;

    private Instant startPriceDateTime;

    private Instant endPriceDateTime;
}
