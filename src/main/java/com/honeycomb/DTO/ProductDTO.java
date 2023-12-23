package com.honeycomb.DTO;

import com.honeycomb.Entity.PricingHistory;
import com.honeycomb.Entity.ProductCategory;
import com.honeycomb.Entity.WishlistItem;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ProductDTO {

    private Long id;

    private String name;

    private String description;

    private Integer code;

    private Double price;

    private Double discount;

    private Integer stock;

    private ProductCategoryDTO category;

    private List<PricingHistoryDTO> pricingHistories;

    private List<WishlistItemDTO> wishlistItems;
}
