package com.tech_challenge_4.product_application.controller;

import com.tech_challenge_4.product_application.entity.Product;
import com.tech_challenge_4.product_application.entity.UpdateProductRequest;
import com.tech_challenge_4.product_application.service.ProductService;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(
            ProductService productService
    ) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        Product createdProduct = productService.create(product);
        return ResponseEntity.ok(createdProduct);
    }

    @GetMapping
    public ResponseEntity<List<Product>> readAll() {
        List<Product> products = productService.readAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> readById(@PathVariable UUID id) {
        Product product = productService.readById(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/validate/{id}/{quantity}")
    public ResponseEntity<String> validateItem(
            @PathVariable UUID id,
            @PathVariable int quantity
    ) {
        productService.validateItem(id, quantity);
        return ResponseEntity.ok("Valid product");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(
            @PathVariable UUID id,
            @RequestBody UpdateProductRequest productRequest
    ) {
        Product updatedProduct = productService.update(
                id,
                productRequest.name(),
                productRequest.description(),
                productRequest.price()
        );
        return ResponseEntity.ok(updatedProduct);
    }

    @PutMapping("/add-quantity/{id}/{quantity}")
    public ResponseEntity<Product> addQuantity(
            @PathVariable UUID id,
            @PathVariable Integer quantity
    ) {
        Product updatedProduct = productService.addQuantity(id, quantity);
        return ResponseEntity.ok(updatedProduct);
    }

    @PutMapping("/remove-quantity/{id}/{quantity}")
    public ResponseEntity<Product> removeQuantity(
            @PathVariable UUID id,
            @PathVariable Integer quantity
    ) {
        Product updatedProduct = productService.removeQuantity(id, quantity);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        productService.deleteById(id);
        return ResponseEntity.ok("Product deleted successfully");
    }
}
