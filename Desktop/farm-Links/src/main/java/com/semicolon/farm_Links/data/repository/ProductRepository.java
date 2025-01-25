package com.semicolon.farm_Links.data.repository;

import com.semicolon.farm_Links.data.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory(String category);



}
