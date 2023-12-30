package com.honeycomb.Service.Impl;

import com.honeycomb.DTO.ProductCategoryDTO;
import com.honeycomb.DTO.ProductDTO;
import com.honeycomb.Entity.Product;
import com.honeycomb.Entity.ProductCategory;
import com.honeycomb.Exceptions.ExceptionConstants;
import com.honeycomb.Exceptions.ResourceNotFoundException;
import com.honeycomb.Repository.ProductCategoryRepo;
import com.honeycomb.Responses.ApiConstants;
import com.honeycomb.Responses.ApiResponse;
import com.honeycomb.Responses.ProductCategoryResponse;
import com.honeycomb.Responses.ProductResponse;
import com.honeycomb.Service.ProductCategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductCategoryRepo productCategoryRepo;

    @Override
    public ProductCategoryDTO create(ProductCategoryDTO productCategoryDTO) {
        productCategoryDTO.setDateCreated(Instant.now());
        ProductCategory category = this.modelMapper.map(productCategoryDTO, ProductCategory.class);

        ProductCategoryDTO responseProductCategoryDTO = this.modelMapper.map(this.productCategoryRepo.save(category), ProductCategoryDTO.class);
        responseProductCategoryDTO.setResponse(new ApiResponse(ApiConstants.PRODUCT_CATEGORY_CREATED, ApiConstants.API_SUCCESS_TRUE, HttpStatus.CREATED));

        return responseProductCategoryDTO;
    }

    @Override
    public ProductCategoryDTO getProductCategoryById(String productCategoryId) {
        ProductCategory category = this.productCategoryRepo.findById(productCategoryId).orElseThrow(() -> new ResourceNotFoundException(ExceptionConstants.PRODUCT_CATEGORY_NOT_FOUND + productCategoryId));

        ProductCategoryDTO responseProductCategoryDTO = this.modelMapper.map(category, ProductCategoryDTO.class);
        responseProductCategoryDTO.setResponse(new ApiResponse(ApiConstants.PRODUCT_CATEGORY_FOUND, ApiConstants.API_SUCCESS_TRUE, HttpStatus.OK));

        return responseProductCategoryDTO;
    }

    @Override
    public ProductCategoryDTO update(String productCategoryId, ProductCategoryDTO productCategoryDTO) {
        ProductCategory category = this.productCategoryRepo.findById(productCategoryId).orElseThrow(() -> new ResourceNotFoundException(ExceptionConstants.PRODUCT_CATEGORY_NOT_FOUND + productCategoryId));

        category.setName(productCategoryDTO.getName());
        category.setDescription(productCategoryDTO.getDescription());
        category.setCode(productCategoryDTO.getCode());
        category.setAttributes(productCategoryDTO.getAttributes());

        ProductCategoryDTO responseProductCategoryDTO = this.modelMapper.map(this.productCategoryRepo.save(category), ProductCategoryDTO.class);
        responseProductCategoryDTO.setResponse(new ApiResponse(ApiConstants.PRODUCT_CATEGORY_UPDATED, ApiConstants.API_SUCCESS_TRUE, HttpStatus.OK));

        return responseProductCategoryDTO;
    }

    @Override
    public ProductCategoryResponse getAllProductCategories(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        Page<ProductCategory> pageProductCategory = this.productCategoryRepo.findAll(pageable);
        List<ProductCategory> allProductCategories = pageProductCategory.getContent();

        List<ProductCategoryDTO> productCategoryDTOList = allProductCategories.stream().map(productCategory -> this.modelMapper.map(productCategory, ProductCategoryDTO.class)).collect(Collectors.toList());

        ProductCategoryResponse productCategoryResponse = new ProductCategoryResponse();
        productCategoryResponse.setContent(productCategoryDTOList);
        productCategoryResponse.setPageNumber(pageProductCategory.getNumber());
        productCategoryResponse.setPageSize(pageProductCategory.getSize());
        productCategoryResponse.setTotalElements(pageProductCategory.getTotalElements());
        productCategoryResponse.setTotalPages(pageProductCategory.getTotalPages());
        productCategoryResponse.setLastPage(pageProductCategory.isLast());
        productCategoryResponse.setResponse(new ApiResponse(pageProductCategory.getTotalElements() > 0 ? ApiConstants.PRODUCT_CATEGORY_FOUND : ApiConstants.PRODUCT_CATEGORY_NOT_FOUND, ApiConstants.API_SUCCESS_TRUE, HttpStatus.OK));

        return productCategoryResponse;
    }

    @Override
    public ApiResponse deleteProductCategoryById(String productCategoryId) {
        if(this.productCategoryRepo.findById(productCategoryId).isEmpty()) {
            throw new ResourceNotFoundException(ExceptionConstants.PRODUCT_CATEGORY_NOT_FOUND + productCategoryId);
        }

        this.productCategoryRepo.deleteById(productCategoryId);

        return new ApiResponse(ApiConstants.PRODUCT_CATEGORY_DELETED, ApiConstants.API_SUCCESS_TRUE, HttpStatus.OK);
    }


}
