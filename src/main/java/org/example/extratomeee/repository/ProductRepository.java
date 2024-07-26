package org.example.extratomeee.repository;

import org.example.extratomeee.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    boolean existByName(String name);

    void deleteById(Integer id);
}
