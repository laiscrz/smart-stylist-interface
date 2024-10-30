package com.leadtech.SmartStylist.service;

import com.leadtech.SmartStylist.model.Product;
import com.leadtech.SmartStylist.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService {
    @Autowired
    private IdGeneratorService idGeneratorService;

    @Autowired
    private IProductRepository productRepository;


    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(String id) {
        return productRepository.findById(id);
    }

    public void save(Product product) {
        // Somente gerar um novo ID se o produto ainda não tiver um ID definido
        if (product.getId() == null || product.getId().isEmpty()) {
            String id = idGeneratorService.generateId("P", "product");
            product.setId(id);
        }
        productRepository.save(product);
    }

    public void update(String id, Product product) {
        // Verifica se o produto existe
        if (!productRepository.existsById(id)) {
            throw new IllegalArgumentException("Produto não encontrado com id: " + id);
        }
        product.setId(id);
        productRepository.save(product);
    }

    public void deleteById(String id) {
        productRepository.deleteById(id);
    }
}
