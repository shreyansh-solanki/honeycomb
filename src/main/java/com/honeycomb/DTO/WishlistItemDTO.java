package com.honeycomb.DTO;

import com.honeycomb.Entity.Product;
import com.honeycomb.Entity.Wishlist;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WishlistItemDTO {
    private Long id;

    private WishlistDTO wishlist;

    private ProductDTO product;
}
