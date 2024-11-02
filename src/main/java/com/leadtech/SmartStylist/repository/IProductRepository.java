package com.leadtech.SmartStylist.repository;

import com.leadtech.SmartStylist.model.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends MongoRepository<Product, String> {

    @Query("{ 'nome' : { $regex: ?0, $options: 'i' } }")
    List<Product> findByNameContaining(String nome);

    @Query("{ 'categoria' : { $regex: ?0, $options: 'i' } }")
    List<Product> findByCategoriaContaining(String categoria);

    @Query("{ 'preco' : { $gte: ?0, $lte: ?1 } }")
    List<Product> findByPrecoBetween(Double precoMin, Double precoMax);

}

