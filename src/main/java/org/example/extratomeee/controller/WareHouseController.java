package org.example.extratomeee.controller;

import org.example.extratomeee.dto.WareHouseDto;
import org.example.extratomeee.model.Result;
import org.example.extratomeee.model.WareHouse;
import org.example.extratomeee.repository.WareHouseRepository;
import org.example.extratomeee.service.WareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WareHouseController {
    @Autowired
    private WareHouseService wareHouseService;


    @GetMapping
    public WareHouseRepository getAllWareHouses() {
        return  wareHouseService.getWareHouseRepository();
    }
    @GetMapping
    public WareHouseRepository getWareHouseRepositorybyId(Integer id) {
        return  wareHouseService.getWareHouseRepositoryById(id);
    }
    @PostMapping
    public Result addWareHouse(WareHouseDto wareHouseDto){
        Result result = wareHouseService.createWareHouseRepository(wareHouseDto);
        return result;}


    // update    id qolib keetgan


    @PutMapping
    public Result updateWareHouse(WareHouseDto wareHouseDto){
        Result result = wareHouseService.updateWareHouseRepository(wareHouseDto);
        return result;
    }
    @DeleteMapping
    public Result deleteWareHouse(Integer id){
        Result result = wareHouseService.deleteWareHouseRepository(id);
        return result;
    }
}
