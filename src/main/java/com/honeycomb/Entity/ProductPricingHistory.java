package com.honeycomb.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("product_pricing_histories")
public class ProductPricingHistory {

    @Id
    private String id;

    private String productId;

    private Double oldPrice;

    private Double newPrice;

    private Instant changeDate;

    private String changeReason;
}
