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

    // id yo'q
    @PutMapping
    public Result updateProduct(@PathVariable Integer id,@RequestBody InPutProdDto inPutProdDto ) {
        Result result = inPutProdService.updateInPutProduct(id , inPutProdDto);
        return result;
    }


    // inputDto bo'maydi  faqat id boladi

    @DeleteMapping
    public Result deleteProduct(@PathVariable Integer id) {
        Result result = inPutProdService.deleteInPutProduct(id);
        return result;
    }

}
