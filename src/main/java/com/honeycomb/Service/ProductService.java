package com.honeycomb.Service;

import com.honeycomb.DTO.ProductDTO;

public interface ProductService {

    ProductDTO create(ProductDTO productDTO);

    ProductDTO getProductById(String productId);
}
