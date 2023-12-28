package com.honeycomb.Service;

import com.honeycomb.DTO.ProductDTO;
import com.honeycomb.Responses.ApiResponse;

public interface ProductService {

    ProductDTO create(ProductDTO productDTO);

    ProductDTO getProductById(String productId);

    ApiResponse deleteProductById(String productId);
}
