package org.example.extratomeee.service;

import org.example.extratomeee.dto.CategoryDto;
import org.example.extratomeee.model.Category;
import org.example.extratomeee.model.Result;
import org.example.extratomeee.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> categoriesAll() {
        return categoryRepository.findAll();
    }
    public Category categoryById(Integer id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            return optionalCategory.get();
        }
        return null;
    }
    public Result createCategory(CategoryDto categoryDto) {
        boolean existed = categoryRepository.existByName1(categoryDto.getName());
        if (existed) {
            return new Result(false, "Category already exists");
        }
        Category category = new Category();
        category.setName(categoryDto.getName());
        categoryRepository.save(category);
        return new Result(true, "Category created");
    }
    public Result updateCategory(CategoryDto categoryDto, Integer id) {
        Optional<Category> optional = categoryRepository.findById(id);
        if (optional.isPresent()) {
            Category category = optional.get();
            category.setName(categoryDto.getName());
            categoryRepository.save(category);
            return new Result(true, "Category updated");
        }
        return new Result(false, "Category not found");
    }
    public Result deleteCategory(Integer id) {
        Optional<Category> optional = categoryRepository.findById(id);
        if (optional.isPresent()) {
            Category category = optional.get();
            categoryRepository.delete(category);
            return new Result(true, "Category deleted");
        }
        return new Result(false, "Category not found");
    }
}
