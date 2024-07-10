package com.tech_challenge_4.product_application.cloud_function;

import com.tech_challenge_4.product_application.entity.Product;
import com.tech_challenge_4.product_application.entity.dto.ProductDTO;
import com.tech_challenge_4.product_application.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;

@Component
public class ProductCloudFunction {

    private final ProductService productService;

    public ProductCloudFunction(ProductService productService) {
        this.productService = productService;
    }

    @Bean
    Function<List<UUID>, List<ProductDTO>> readProductsByIdList() {
        return productsId -> {
            List<Product> products = this.productService.readProductsByIdList(productsId);
            return products.stream().map(Product::toDTO).toList();
        };
    }

}
