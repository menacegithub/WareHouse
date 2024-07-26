package org.example.extratomeee.service;

import org.example.extratomeee.dto.ProductDto;
import org.example.extratomeee.model.*;
import org.example.extratomeee.repository.AttachmentRepository;
import org.example.extratomeee.repository.CategoryRepository;
import org.example.extratomeee.repository.MeasurmentRepository;
import org.example.extratomeee.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    private MeasurmentRepository measurmentRepository;

    @Autowired
    AttachmentRepository attachmentRepository;

    public List<Product> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        return productList;
    }
    public Product getProductById(Integer id) {
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.get();
    }

    //create
    public Result createProduct(ProductDto productDto) {
        boolean existByName = productRepository.existByName(productDto.getName());
        if (existByName) {
            return new Result(false,"Already exists");

        }
        Product product = new Product();
        product.setName(productDto.getName());
        product.setCode(productDto.getCode());
        Optional<Category> categoryOptional = categoryRepository.findById(productDto.getCategoryId());
        Category category = categoryOptional.get();
        product.setCategory((List<Category>) category);
        Optional<Measurement> measurementOptional = measurmentRepository.findById(productDto.getMeasurement());
        Measurement measurement = measurementOptional.get();
        product.setMeasurement(measurement);

        Optional<Attachment> attachmentOptional = attachmentRepository.findById(productDto.getAttachment());
        Attachment attachment = attachmentOptional.get();
        product.setAttachment(attachment);
        productRepository.save(product);
        return new Result(true,"Product created");

    }

    public Result updateProduct(Integer id,ProductDto productDto) {
        if (!productRepository.existsById(id)) {
            return new Result(false,"Product not found");
        }
        return new Result(false,"not found");
    }

    public Result deleteProduct(Integer id) {
        if (!productRepository.existsById(id)) return new Result(false, "Product not found");
        productRepository.deleteById(id);
        return new Result(true,"Deleted");
    }
}
