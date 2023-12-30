package com.honeycomb.Controller;

import com.honeycomb.DTO.ProductCategoryDTO;
import com.honeycomb.Responses.ApiConstants;
import com.honeycomb.Responses.ApiResponse;
import com.honeycomb.Responses.ProductCategoryResponse;
import com.honeycomb.Responses.ProductResponse;
import com.honeycomb.Service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product-categories")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @PostMapping("")
    public ResponseEntity<ProductCategoryDTO> createProductCategory(@RequestBody ProductCategoryDTO productCategoryDTO) {
        return new ResponseEntity<>(this.productCategoryService.create(productCategoryDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{productCategoryId}")
    public ResponseEntity<ProductCategoryDTO> getProductCategoryById(@PathVariable("productCategoryId") String productCategoryId) {
        return new ResponseEntity<>(this.productCategoryService.getProductCategoryById(productCategoryId), HttpStatus.OK);
    }

    @PutMapping("/{productCategoryId}")
    public ResponseEntity<ProductCategoryDTO> updateProductCategoryById(@PathVariable("productCategoryId") String productCategoryId, @RequestBody ProductCategoryDTO productCategoryDTO) {
        return new ResponseEntity<>(this.productCategoryService.update(productCategoryId, productCategoryDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{productCategoryId}")
    public ResponseEntity<ApiResponse> deleteProductCategoryById(@PathVariable("productCategoryId") String productCategoryId) {
        return new ResponseEntity<>(this.productCategoryService.deleteProductCategoryById(productCategoryId), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<ProductCategoryResponse> getAllProducts(@RequestParam(value = "pageNumber", defaultValue = ApiConstants.PAGE_NUMBER, required = false) Integer pageNumber,
                                                                  @RequestParam(value = "pageSize", defaultValue = ApiConstants.PAGE_SIZE, required = false) Integer pageSize,
                                                                  @RequestParam(value = "sortBy", defaultValue = ApiConstants.SORT_BY, required = false) String sortBy,
                                                                  @RequestParam(value = "sortDir", defaultValue = ApiConstants.SORT_DIR, required = false) String sortDir
    ) {
        return new ResponseEntity<>(this.productCategoryService.getAllProductCategories(pageNumber, pageSize, sortBy, sortDir), HttpStatus.OK);
    }
}
