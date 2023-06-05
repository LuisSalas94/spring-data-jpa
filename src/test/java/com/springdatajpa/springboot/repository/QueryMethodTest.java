package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
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

    @Test
    void findDistinctByNameMethod() {
        Product product = productRepository.findDistinctByName("product 2");
        System.out.println("Id: " + product.getId());
        System.out.println("Name: " + product.getName());
        System.out.println("Description: " + product.getDescription());
    }

    @Test
    void findByPriceGreaterThanMethod() {
        List<Product> productList = productRepository.findByPriceGreaterThan(new BigDecimal(100));
        for(Product product: productList) {
            System.out.println("Name: " + product.getName());
            System.out.println("Description: " + product.getDescription());
            System.out.println("Price: " + product.getPrice());
            System.out.println("*************************************");
        }
    }

    @Test
    void findByPriceLessThan() {
        List<Product> productList = productRepository.findByPriceLessThan(new BigDecimal(300));
        for(Product product: productList) {
            System.out.println("Name: " + product.getName());
            System.out.println("Description: " + product.getDescription());
            System.out.println("Price: " + product.getPrice());
            System.out.println("*************************************");
        }
    }

    @Test
    void findByNameContaining() {
        List<Product> productList = productRepository.findByNameContaining("product");
        for(Product product: productList) {
            System.out.println("Name: " + product.getName());
            System.out.println("Description: " + product.getDescription());
            System.out.println("*************************************");
        }
    }

    @Test
    void findByNameLikeMethod() {
        List<Product> productList = productRepository.findByNameLike("product 1");
        for(Product product: productList) {
            System.out.println("Name: " + product.getName());
            System.out.println("Description: " + product.getDescription());
            System.out.println("*************************************");
        }
    }

    @Test
    void findByPriceBetweenMethod() {
        List<Product> productList = productRepository.findByPriceBetween(new BigDecimal(200), new BigDecimal(300));
        for(Product product: productList) {
            System.out.println("Name: " + product.getName());
            System.out.println("Description: " + product.getDescription());
            System.out.println("Price: " + product.getPrice());
            System.out.println("*************************************");
        }
    }

}
