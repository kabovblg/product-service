package com.blagovestkabov.productservice.repository;

import com.blagovestkabov.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface ProductRepository extends JpaRepository<Product, Long> {
}
