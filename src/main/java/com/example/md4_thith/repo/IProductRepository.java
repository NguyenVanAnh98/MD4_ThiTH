package com.example.md4_thith.repo;

import com.example.md4_thith.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
}
