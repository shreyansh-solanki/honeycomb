package com.honeycomb.Repository;

import com.honeycomb.Entity.ProductCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductCategoryRepo extends MongoRepository<ProductCategory, String> {
}
