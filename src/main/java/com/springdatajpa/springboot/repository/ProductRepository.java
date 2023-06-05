package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    /*
    * Returns the found product entry by using its name as search
    * criteria. If not product entry is found, this method returns null;
    * */
    public Product findByName(String name);
    public Product findByDescription(String description);

    /*
    * Returns an Optional which contains the found product entry by using its od as search
    * criteria. If no product entry is found, this method returns an empty Optional
    * */
    Optional<Product> findById(Long id);

    /*
    * Returns the found list of product entries whose title or description is given as
    * method parameter. If no product entries is found, this method returns an empty list.
    * */
    List<Product> findByNameOrDescription(String name, String description);

    /*
     * Returns the found list of product entries whose title and description is given as
     * method parameter. If no product entries is found, this method returns an empty list.
     * */
    List<Product> findByNameAndDescription(String name, String description);

    /*
    * Return the distinct product entry whose name is given as a method parameter
    * If no product entry is found, this method returns null.
    * */
    Product findDistinctByName(String name);

}
