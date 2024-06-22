package com.tech_challenge_4.product_application.service;

import com.tech_challenge_4.product_application.entity.Product;
import com.tech_challenge_4.product_application.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public List<Product> readAll() {
        return productRepository.findAll();
    }

    public Product readById(UUID id) {
        return productRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Product update(UUID id, String name, String description, Double price) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            product.setName(name);
            product.setDescription(description);
            product.setPrice(price);
            product = productRepository.save(product);
            return product;
        } else {
            throw new EntityNotFoundException();
        }
    }

    public Product addQuantity(UUID id, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            product.addQuantity(quantity);
            product = productRepository.save(product);
            return product;
        } else {
            throw new EntityNotFoundException();
        }
    }

    public Product removeQuantity(UUID id, int quantity) {
        if (quantity >= 0) {
            throw new IllegalArgumentException("Quantity must be less than 0");
        }
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            product.removeQuantity(quantity);
            product = productRepository.save(product);
            return product;
        } else {
            throw new EntityNotFoundException();
        }
    }

    public void delete(UUID id) {
        Product currentUser = productRepository.findById(id).orElse(null);
        if (currentUser != null) {
            productRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException();
        }
    }
}
