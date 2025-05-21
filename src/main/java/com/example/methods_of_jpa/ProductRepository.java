package com.example.methods_of_jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product, String> {
    Optional<Product> findByProductName(String productName);
  
    List<Product> findAllByProductPriceBetween(double price1, double price2);

    Optional<Product> findAllByProductBrandAndProductPrice(String productBrand, double productPrice);

    List<Product> findAllByProductPriceGreaterThan(double price, Sort sort);

    List<Product> findAllByProductPriceLessThan(double price, Sort sort);

    List<Product> findAllByProductPriceLessThanEqual(double price, Sort sort);

    List<Product> findAllByProductPriceGreaterThanEqual(double price, Sort sort);

    List<Product> findByProductNameLike(String productName);

    List<Product> findByProductNameNotLike(String productName);

    List<Product> findByProductNameStartingWith(String productName);

    List<Product> findByProductNameEndingWith(String productName);

    List<Product> findByProductNameContaining(String productName);
    
    List<Product> findByProductNameNotContaining(String productName);


}
