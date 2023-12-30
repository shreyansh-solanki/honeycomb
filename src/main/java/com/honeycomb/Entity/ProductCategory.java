package com.honeycomb.Entity;

import com.honeycomb.Responses.ApiResponse;
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
@Document("product_categories")
public class ProductCategory {

    @Id
    private String id;

    private String name;

    private String description;

    private Integer code;

    private Map<String, String> attributes;

    private Instant dateCreated;
}
