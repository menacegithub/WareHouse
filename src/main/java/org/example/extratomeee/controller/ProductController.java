package org.example.extratomeee.controller;

import org.example.extratomeee.dto.ProductDto;
import org.example.extratomeee.model.Product;
import org.example.extratomeee.model.Result;
import org.example.extratomeee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> getallProducts() {
        List<Product> list = productService.getAllProducts();
        return list;
    }
    @GetMapping("/{id}")
    public Product getbyid(@PathVariable int id) {
        Product product = productService.getProductById(id);
        return product;
    }
    @PostMapping
    public Result add(@RequestBody ProductDto productDto) {
        Result result = productService.createProduct(productDto);
        return result;
    }
    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id, @RequestBody ProductDto productDto){
        Result result = productService.updateProduct(id, productDto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result del(@PathVariable Integer id){
        Result result = productService.deleteProduct(id);
        return result;
}
}

