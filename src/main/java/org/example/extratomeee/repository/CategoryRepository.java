package org.example.extratomeee.repository;

import org.example.extratomeee.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existByName1(String name);

    void deleteById(Integer id);

    Optional<Category> findById(Integer categoryId);
}
