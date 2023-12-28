package com.honeycomb.Controller;

import com.honeycomb.DTO.ProductDTO;
import com.honeycomb.Responses.ApiResponse;
import com.honeycomb.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        return new ResponseEntity<>(this.productService.create(productDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("productId") String productId) {
        return new ResponseEntity<>(this.productService.getProductById(productId), HttpStatus.OK);
    }

    @DeleteMapping("{productId}")
    public ResponseEntity<ApiResponse> deleteProductById(@PathVariable("productId") String productId) {
        return new ResponseEntity<>(this.productService.deleteProductById(productId), HttpStatus.OK);
    }
}
