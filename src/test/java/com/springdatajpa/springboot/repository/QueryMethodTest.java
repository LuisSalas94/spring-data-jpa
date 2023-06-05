package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class QueryMethodTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod() {
        Product product = productRepository.findByName("product 2");
        System.out.println("Id: " + product.getId());
        System.out.println("Name: " + product.getName());
        System.out.println("Description: " + product.getDescription());
    }

    @Test
    void findByDescriptionMethod() {
        Product product = productRepository.findByDescription("product 2 description");
        System.out.println("Description: " + product.getDescription());
    }

    @Test
    void findByIdMethod() {
        Product product = productRepository.findById(1L).get();
        System.out.println("Id: " + product.getId());
        System.out.println("Name: " + product.getName());
        System.out.println("Description: " + product.getDescription());
    }

    @Test
    void findByNameOrDescriptionMethod() {
        List<Product> productList = productRepository.findByNameOrDescription("product 2", "product 2 description");
        for(Product product: productList) {
            System.out.println("Name: " + product.getName());
            System.out.println("Description: " + product.getDescription());
        }
    }

    @Test
    void findByNameAndDescriptionMethod() {
        List<Product> productList = productRepository.findByNameAndDescription("product 2", "product 2 description");
        for(Product product: productList) {
            System.out.println("Name: " + product.getName());
            System.out.println("Description: " + product.getDescription());
        }
    }


}
