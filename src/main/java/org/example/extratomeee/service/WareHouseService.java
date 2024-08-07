package org.example.extratomeee.service;

import org.example.extratomeee.dto.WareHouseDto;
import org.example.extratomeee.model.Result;
import org.example.extratomeee.model.WareHouse;
import org.example.extratomeee.repository.WareHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WareHouseService {
    @Autowired
    WareHouseRepository wareHouseRepository;
    public WareHouseRepository getWareHouseRepository() {
        return wareHouseRepository;
    }
    public WareHouseRepository getWareHouseRepositoryById(Integer id) {
        Optional<WareHouse> wareHouseOptional = wareHouseRepository.findById(id);
        if (wareHouseOptional.isPresent()) {
            return wareHouseRepository;
        }
        return null;
    }
    public Result createWareHouseRepository(WareHouseDto wareHouseDto) {
        WareHouse wareHouse = new WareHouse();
        wareHouse.setName(wareHouseDto.getName());
        return new Result(true,"Created");
    }
    public Result updateWareHouseRepository( Integer id , WareHouseDto wareHouseDto) {
        Optional<WareHouse> optional = wareHouseRepository.findById(id);
        if (optional.isPresent()) {


            WareHouse wareHouse = new WareHouse();
            wareHouse.setName(wareHouseDto.getName());
            return new Result(true, "Updated");
        }
        return new Result(false,"not  ");
    }
    public Result deleteWareHouseRepository(Integer id) {
        wareHouseRepository.deleteById(id);
        return new Result(true,"Deleted");
    }
}
