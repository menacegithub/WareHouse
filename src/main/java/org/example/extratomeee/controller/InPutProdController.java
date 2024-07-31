package org.example.extratomeee.controller;

import org.example.extratomeee.dto.InPutProdDto;
import org.example.extratomeee.model.Result;
import org.example.extratomeee.service.InPutProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InPutProdController {
    @Autowired
    InPutProdService inPutProdService;
    @GetMapping
    public InPutProdService getProducts() {
        return (InPutProdService) inPutProdService.getAllInPutproductRepository();
    }
    @GetMapping
    public InPutProdService getProductById(@PathVariable Integer id) {
        return (InPutProdService) inPutProdService.getInPutProductRepositorybyId(id);
    }
    @PostMapping
    public Result addProduct(@RequestBody InPutProdDto inPutProdDto ) {
        Result inPutProduct = inPutProdService.createInPutProduct(inPutProdDto);
        return inPutProduct;
    }
    @PutMapping
    public Result updateProduct(@RequestBody InPutProdDto inPutProdDto ) {
        Result result = inPutProdService.updateInPutProduct(inPutProdDto);
        return result;
    }
    @DeleteMapping
    public Result deleteProduct(@PathVariable Integer id,@RequestBody InPutProdDto inPutProdDto ) {
        Result result = inPutProdService.deleteInPutProduct(id);
        return result;
    }

}
