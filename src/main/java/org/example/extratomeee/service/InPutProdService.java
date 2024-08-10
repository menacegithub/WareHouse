package org.example.extratomeee.service;

import org.example.extratomeee.dto.InPutProdDto;
import org.example.extratomeee.model.InputProduct;
import org.example.extratomeee.model.Product;
import org.example.extratomeee.model.Result;
import org.example.extratomeee.repository.InPutProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InPutProdService {
    @Autowired
    private InPutProductRepository productRepository;

    public InPutProductRepository getAllInPutproductRepository() {
        return productRepository;
    }
    public InPutProductRepository getInPutProductRepositorybyId(Integer id) {
        Optional<Product> productOptional = productRepository.findById(id);
        return (InPutProductRepository) productOptional.get();
    }
    public Result createInPutProduct(InPutProdDto inPutProdDto) {
        InputProduct inputProduct = new InputProduct();
        inputProduct.setProduct(inPutProdDto.getProduct());
        inputProduct.setPrice(inPutProdDto.getPrice());
        return new Result(true, "Product created");
    }
    public Result updateInPutProduct(Integer id, InPutProdDto inPutProdDto) {
        InputProduct inputProduct = new InputProduct();
        inputProduct.setProduct(inPutProdDto.getProduct());
        inputProduct.setPrice(inPutProdDto.getPrice());
        return new Result(true, "Product updated");

    }
    public Result deleteInPutProduct(Integer id) {
        productRepository.deleteById(id);
        return new Result(true, "Product deleted");
    }

}
