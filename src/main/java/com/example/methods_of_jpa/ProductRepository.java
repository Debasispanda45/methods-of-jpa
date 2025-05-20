package com.example.methods_of_jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product, String> {
    Optional<Product> findByProductName(String productName);
  
    List<Product> findAllByProductPriceBetween(double price1, double price2);

    //List<Product> findAllByProductBrand(String productBrand);

    Optional<Product> findAllByProductBrandAndProductPrice(String productBrand, double productPrice);

    List<Product> findAllByProductPriceGreaterThan(double price, Sort sort);
}
