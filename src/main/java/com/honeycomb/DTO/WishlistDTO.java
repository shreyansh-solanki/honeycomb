package com.honeycomb.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WishlistDTO {
    private Long id;

    private UserDTO user;

    private List<WishlistItemDTO> wishlistItems;
}
