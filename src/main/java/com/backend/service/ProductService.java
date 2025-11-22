package com.backend.service;

import com.backend.entity.Product;
import com.backend.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> getAll() {
        return repo.findAll();
    }

    public Product add(Product product) {
        return repo.save(product);
    }

    public Product update(Long id, Product newProduct) {
        Product old = repo.findById(id).orElseThrow();
        old.setName(newProduct.getName());
        old.setCategory(newProduct.getCategory());
        old.setUnit(newProduct.getUnit());
        old.setCurrentStock(newProduct.getCurrentStock());
        old.setMinimumStock(newProduct.getMinimumStock());
        return repo.save(old);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
