package com.leadtech.SmartStylist.repository;

import com.leadtech.SmartStylist.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends MongoRepository<Product, String> {
}
