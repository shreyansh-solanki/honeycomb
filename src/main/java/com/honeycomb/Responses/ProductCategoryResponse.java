package com.honeycomb.Responses;

import com.honeycomb.DTO.ProductCategoryDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductCategoryResponse {
    private List<ProductCategoryDTO> content;
    private Integer pageNumber;
    private Integer pageSize;
    private Long totalElements;
    private Integer totalPages;
    private boolean lastPage;
    private ApiResponse response;
}
