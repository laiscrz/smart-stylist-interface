package com.leadtech.SmartStylist.repository;

import com.leadtech.SmartStylist.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IProductRepository extends MongoRepository<Product, String> {
}
