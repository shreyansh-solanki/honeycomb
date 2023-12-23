package com.honeycomb.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductCategoryDTO {

    private Long id;

    private String name;

    private String description;

    private Integer code;

    private List<ProductDTO> products;
}
