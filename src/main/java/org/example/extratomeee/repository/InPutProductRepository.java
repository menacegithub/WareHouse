package org.example.extratomeee.repository;

import org.example.extratomeee.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InPutProductRepository extends JpaRepository<Product, Integer> {
}
