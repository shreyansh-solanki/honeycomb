package com.honeycomb.Service;

import com.honeycomb.DTO.ProductDTO;
import com.honeycomb.Responses.ApiResponse;
import com.honeycomb.Responses.ProductResponse;

public interface ProductService {

    ProductDTO create(ProductDTO productDTO);

    ProductDTO getProductById(String productId);

    ApiResponse deleteProductById(String productId);

    ProductDTO update(String productId, ProductDTO productDTO);

    ProductResponse getAllProducts(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
}
