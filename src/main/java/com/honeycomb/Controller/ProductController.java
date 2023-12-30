package com.honeycomb.Controller;

import com.honeycomb.DTO.ProductDTO;
import com.honeycomb.Responses.ApiConstants;
import com.honeycomb.Responses.ApiResponse;
import com.honeycomb.Responses.ProductResponse;
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

    // Creating a product
    @PostMapping("")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        return new ResponseEntity<>(this.productService.create(productDTO), HttpStatus.CREATED);
    }

    // Getting product by product id
    @GetMapping("/{productId}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("productId") String productId) {
        return new ResponseEntity<>(this.productService.getProductById(productId), HttpStatus.OK);
    }

    // Updating product by product id
    @PutMapping("/{productId}")
    public ResponseEntity<ProductDTO> updateProductById(@PathVariable("productId") String productId, @RequestBody ProductDTO productDTO) {
        return new ResponseEntity<>(this.productService.update(productId, productDTO), HttpStatus.OK);
    }

    // Deleting product by product id
    @DeleteMapping("{productId}")
    public ResponseEntity<ApiResponse> deleteProductById(@PathVariable("productId") String productId) {
        return new ResponseEntity<>(this.productService.deleteProductById(productId), HttpStatus.OK);
    }

    // Getting all Products
    @GetMapping("")
    public ResponseEntity<ProductResponse> getAllProducts(@RequestParam(value = "pageNumber", defaultValue = ApiConstants.PAGE_NUMBER, required = false) Integer pageNumber,
                                                       @RequestParam(value = "pageSize", defaultValue = ApiConstants.PAGE_SIZE, required = false) Integer pageSize,
                                                       @RequestParam(value = "sortBy", defaultValue = ApiConstants.SORT_BY, required = false) String sortBy,
                                                       @RequestParam(value = "sortDir", defaultValue = ApiConstants.SORT_DIR, required = false) String sortDir
    ) {
        return new ResponseEntity<>(this.productService.getAllProducts(pageNumber, pageSize, sortBy, sortDir), HttpStatus.OK);
    }
}
