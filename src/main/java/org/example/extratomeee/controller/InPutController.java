package org.example.extratomeee.controller;

import org.example.extratomeee.dto.InPutDto;
import org.example.extratomeee.model.Input;
import org.example.extratomeee.model.Result;
import org.example.extratomeee.service.InPutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InPutController {
    @Autowired
    InPutService inPutService;

    @GetMapping
    public List<Input> getAll(){
        List<Input> list = inPutService.getAllInput();
        return list;
    }
    @GetMapping
    public Input getById(@PathVariable Integer id){
        Input input = inPutService.getInputById(id);
        return input;
    }
    @PostMapping
    public Result add(@RequestBody InPutDto inPutDto){
        Result result = inPutService.createInput(inPutDto);
        return result;
    }
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id,@RequestBody InPutDto inPutDto){
        Result result = inPutService.updateInput(id, inPutDto);
        return result;
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        Result result = inPutService.deleteInput(id);
        return result;
    }
}
