package com.honeycomb.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("products")
public class Product {

    @Id
    private String id;

    private String name;

    private String description;

    private String categoryId;

    private Integer code;

    private Double price;

    private Integer stockQuantity;

    private List<String> images;

    private Map<String, String> attributes;

    private Instant dateAdded;
}
