package com.honeycomb.Service.Impl;

import com.honeycomb.DTO.ProductDTO;
import com.honeycomb.Entity.Product;
import com.honeycomb.Exceptions.ExceptionConstants;
import com.honeycomb.Exceptions.ResourceNotFoundException;
import com.honeycomb.Repository.ProductRepo;
import com.honeycomb.Service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductRepo productRepo;

    @Override
    public ProductDTO create(ProductDTO productDTO) {
        Product product = this.modelMapper.map(productDTO, Product.class);

        return this.modelMapper.map(this.productRepo.save(product), ProductDTO.class);
    }

    @Override
    public ProductDTO getProductById(String productId) {
        Product product = this.productRepo.findById(productId).orElseThrow(() -> new ResourceNotFoundException(ExceptionConstants.PRODUCT_NOT_FOUND + productId));

        return this.modelMapper.map(product, ProductDTO.class);
    }
}
