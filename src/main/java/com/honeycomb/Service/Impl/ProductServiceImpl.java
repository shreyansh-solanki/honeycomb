package com.honeycomb.Service.Impl;

import com.honeycomb.DTO.ProductDTO;
import com.honeycomb.Entity.Product;
import com.honeycomb.Exceptions.ExceptionConstants;
import com.honeycomb.Exceptions.ResourceNotFoundException;
import com.honeycomb.Repository.ProductRepo;
import com.honeycomb.Responses.ApiConstants;
import com.honeycomb.Responses.ApiResponse;
import com.honeycomb.Service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductRepo productRepo;

    @Override
    public ProductDTO create(ProductDTO productDTO) {
        productDTO.setDateAdded(Instant.now());
        Product product = this.modelMapper.map(productDTO, Product.class);

        ProductDTO resposeProductDTO = this.modelMapper.map(this.productRepo.save(product), ProductDTO.class);
        resposeProductDTO.setResponse(new ApiResponse(ApiConstants.PRODUCT_CREATED, ApiConstants.API_SUCCESS_TRUE, HttpStatus.CREATED));

        return resposeProductDTO;
    }

    @Cacheable(value = "products", key = "#id")
    @Override
    public ProductDTO getProductById(String productId) {
        Product product = this.productRepo.findById(productId).orElseThrow(() -> new ResourceNotFoundException(ExceptionConstants.PRODUCT_NOT_FOUND + productId));

        ProductDTO resposeProductDTO = this.modelMapper.map(product, ProductDTO.class);
        resposeProductDTO.setResponse(new ApiResponse(ApiConstants.PRODUCT_FOUND, ApiConstants.API_SUCCESS_TRUE, HttpStatus.OK));

        return resposeProductDTO;
    }

    @CacheEvict(value = "products", key = "#id")
    @Override
    public ApiResponse deleteProductById(String productId) {
        if(this.productRepo.findById(productId).isEmpty()) {
            throw new ResourceNotFoundException(ExceptionConstants.PRODUCT_NOT_FOUND + productId);
        }

        this.productRepo.deleteById(productId);

        return new ApiResponse(ApiConstants.PRODUCT_DELETED, ApiConstants.API_SUCCESS_TRUE, HttpStatus.OK);
    }


}
