package com.honeycomb.Service;

import com.honeycomb.DTO.ProductCategoryDTO;
import com.honeycomb.Responses.ApiResponse;
import com.honeycomb.Responses.ProductCategoryResponse;

public interface ProductCategoryService {


    ProductCategoryDTO create(ProductCategoryDTO productCategoryDTO);

    ProductCategoryDTO getProductCategoryById(String productCategoryId);

    ProductCategoryDTO update(String productCategoryId, ProductCategoryDTO productCategoryDTO);

    ApiResponse deleteProductCategoryById(String productCategoryId);

    ProductCategoryResponse getAllProductCategories(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
}
