package org.example.extratomeee.controller;

import org.example.extratomeee.dto.CategoryDto;
import org.example.extratomeee.model.Category;
import org.example.extratomeee.model.Result;
import org.example.extratomeee.repository.CategoryRepository;
import org.example.extratomeee.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public List<Category> getAllCategories() {
        List<Category> categories = categoryService.categoriesAll();
        return categories;
    }
    @GetMapping
    public Category getCategoryById(@PathVariable Integer id) {
        return categoryService.categoryById(id);
    }

    @PostMapping
    public Result add(@RequestBody CategoryDto categoryDto) {
        Result category = categoryService.createCategory(categoryDto);
        return category;
    }
    @PutMapping
    public Result update(@PathVariable Integer id,@RequestBody CategoryDto categoryDto) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            category.setName(categoryDto.getName());


        }
        return new Result(false, "Category not updated");
    }
    @DeleteMapping
    public Result delete(@PathVariable Integer id) {
        categoryRepository.deleteById(id);
        return new Result(true, "Category deleted");
    }

}
