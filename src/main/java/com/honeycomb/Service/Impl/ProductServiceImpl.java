package com.honeycomb.Service.Impl;

import com.honeycomb.DTO.ProductDTO;
import com.honeycomb.Entity.Product;
import com.honeycomb.Exceptions.ExceptionConstants;
import com.honeycomb.Exceptions.ResourceNotFoundException;
import com.honeycomb.Repository.ProductRepo;
import com.honeycomb.Responses.ApiConstants;
import com.honeycomb.Responses.ApiResponse;
import com.honeycomb.Responses.ProductResponse;
import com.honeycomb.Service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductRepo productRepo;

    @Override
    public ProductDTO create(ProductDTO productDTO) {
        productDTO.setDateAdded(Instant.now());
        Product product = this.modelMapper.map(productDTO, Product.class);

        ProductDTO responseProductDTO = this.modelMapper.map(this.productRepo.save(product), ProductDTO.class);
        responseProductDTO.setResponse(new ApiResponse(ApiConstants.PRODUCT_CREATED, ApiConstants.API_SUCCESS_TRUE, HttpStatus.CREATED));

        return responseProductDTO;
    }

    @Cacheable(value = "products", key = "#id")
    @Override
    public ProductDTO getProductById(String productId) {
        Product product = this.productRepo.findById(productId).orElseThrow(() -> new ResourceNotFoundException(ExceptionConstants.PRODUCT_NOT_FOUND + productId));

        ProductDTO resposeProductDTO = this.modelMapper.map(product, ProductDTO.class);
        resposeProductDTO.setResponse(new ApiResponse(ApiConstants.PRODUCT_FOUND, ApiConstants.API_SUCCESS_TRUE, HttpStatus.OK));

        return resposeProductDTO;
    }

    @Override
    public ProductDTO update(String productId, ProductDTO productDTO) {
        Product product = this.productRepo.findById(productId).orElseThrow(() -> new ResourceNotFoundException(ExceptionConstants.PRODUCT_NOT_FOUND + productId));

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setCategoryId(productDTO.getCategoryId());
        product.setCode(productDTO.getCode());
        product.setPrice(productDTO.getPrice());
        product.setStockQuantity(productDTO.getStockQuantity());
        product.setImages(productDTO.getImages());  // Optional
//        product.setAttributes(productDTO.getAttributes());  // Optional

        ProductDTO resposeProductDTO = this.modelMapper.map(this.productRepo.save(product), ProductDTO.class);
        resposeProductDTO.setResponse(new ApiResponse(ApiConstants.PRODUCT_UPDATED, ApiConstants.API_SUCCESS_TRUE, HttpStatus.OK));

        return resposeProductDTO;
    }

    @Override
    public ProductResponse getAllProducts(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        Page<Product> pageProducts = this.productRepo.findAll(pageable);
        List<Product> allProducts = pageProducts.getContent();

        List<ProductDTO> productDTOList = allProducts.stream().map(product -> this.modelMapper.map(product, ProductDTO.class)).collect(Collectors.toList());

        ProductResponse productResponse = new ProductResponse();
        productResponse.setContent(productDTOList);
        productResponse.setPageNumber(pageProducts.getNumber());
        productResponse.setPageSize(pageProducts.getSize());
        productResponse.setTotalElements(pageProducts.getTotalElements());
        productResponse.setTotalPages(pageProducts.getTotalPages());
        productResponse.setLastPage(pageProducts.isLast());
        productResponse.setResponse(new ApiResponse(productResponse.getTotalElements() > 0 ? ApiConstants.PRODUCT_FOUND : ApiConstants.PRODUCT_NOT_FOUND, ApiConstants.API_SUCCESS_TRUE, HttpStatus.OK));

        return productResponse;
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
