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

    private String id;

    private String productId;

    private Double oldPrice;

    private Double newPrice;

    private Instant changeDate;

    private String changeReason;
}
