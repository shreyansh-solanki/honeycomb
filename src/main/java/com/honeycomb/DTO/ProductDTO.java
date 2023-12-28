package com.honeycomb.DTO;

import com.honeycomb.Entity.ProductCategory;
import com.honeycomb.Entity.WishlistItem;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ProductDTO {

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
