package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod() {
        // create a product
        Product product = new Product();
        // save product
        product.setName("product 1");
        product.setDescription("product 1 description");
        product.setSku("100ABC");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("product1.png");
        // save product
        Product productObj = productRepository.save(product);
        // display product info
        System.out.println("Id: " + productObj.getId());
        System.out.println("Name: " + productObj.getName());
        System.out.println("Description: " + productObj.getDescription());
        System.out.println(productObj.toString());
    }

    @Test
    void updateUsingSaveMethod() {
        // find an entity by id
        Long id = 1L;
        Product product = productRepository.findById(id).get();
        // update entity information
        product.setName("updated product 1");
        product.setDescription("updated product 1 description");
        // save updated entity
        productRepository.save(product);
    }

    @Test
    void findByIdMethod() {
        Long id = 1L;
        Product product = productRepository.findById(id).get();
        System.out.println("Name: " + product.getName());
        System.out.println("Dedscription: " + product.getDescription());
    }

    @Test
    void saveAllMethod() {
        // create a product
        Product product2 = new Product();
        product2.setName("product 2");
        product2.setDescription("product 2 description");
        product2.setSku("200ABC");
        product2.setPrice(new BigDecimal(200));
        product2.setActive(true);
        product2.setImageUrl("product2.png");

        // create a product
        Product product3 = new Product();
        product3.setName("product 3");
        product3.setDescription("product 3 description");
        product3.setSku("300ABC");
        product3.setPrice(new BigDecimal(300));
        product3.setActive(true);
        product3.setImageUrl("product3.png");

        productRepository.saveAll(List.of(product2, product3));
    }

    @Test
    void findAllMethod() {
        List<Product> productList = productRepository.findAll();
        for(Product product:productList) {
            System.out.println("Name: " + product.getName());
            System.out.println("Description: " + product.getDescription());
            System.out.println("******************************************");
        }
    }

    @Test
    void deleteByIdMethod() {
        Long id = 1L;
        productRepository.deleteById(id);
    }

    @Test
    void deleteMethod() {
        // Find an entity my id
        Long id = 2L;
        Product product = productRepository.findById(id).get();
        // delete(entity)
        productRepository.delete(product);
    }

    @Test
    void deleteAllMethod() {
        //productRepository.deleteAll();
        Product product1 = productRepository.findById(5L).get();
        Product product2 = productRepository.findById(6L).get();
        productRepository.deleteAll(List.of(product1, product2));
    }

    @Test
    void countMethod() {
        long count = productRepository.count();
        System.out.println("The number of items is: " + count);
    }

    @Test
    void existsByIdMethod() {
        Long id = 7L;
        boolean result = productRepository.existsById(id);
        System.out.println("Product with id " + id + "exist?" + result);
    }

}