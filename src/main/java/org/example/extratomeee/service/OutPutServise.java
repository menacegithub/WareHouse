package org.example.extratomeee.service;

import org.example.extratomeee.dto.OutPutDto;
import org.example.extratomeee.model.*;
import org.example.extratomeee.repository.ClientRepository;
import org.example.extratomeee.repository.CurrencyRepository;
import org.example.extratomeee.repository.OutPutRepository;
import org.example.extratomeee.repository.WareHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OutPutServise {

    @Autowired
    OutPutRepository outPutRepository;

    @Autowired
    WareHouseRepository wareHouseRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    CurrencyRepository currencyRepository;

    public List<OutPut> getallOutPuts() {
        List<OutPut> outPutList = outPutRepository.findAll();
        return outPutList;
    }
    //create
    public Result createOutPut(OutPutDto outPutDto) {
        OutPut outPut = new OutPut();

        Optional<WareHouse> houseOptional = wareHouseRepository.findById(outPutDto.getWareHouseId());
        WareHouse wareHouse = houseOptional.get();

        outPut.setWarehouse(wareHouse);
        outPut.setCode(outPutDto.getCode());
        outPut.setFactureNumber(outPutDto.getFactureNumber());

        List<Client> clientList = clientRepository.findAll();
        outPut.setClient(clientList);

        Optional<Currency> currencyOptional = currencyRepository.findById(outPutDto.getCurrencyId());
        Currency currency = currencyOptional.get();
        outPut.setCurency((List<Currency>)currency);

        outPutRepository.save(outPut);
        return new Result(true,"success");
    }
    //update
    public Result updateOutPut(Integer id,OutPutDto outPutDto) {
        return new Result(false,"not found");
    }
    //delete
    public Result deleteOutPut(Integer id) {
        outPutRepository.deleteById(id);
        return new Result(true,"Deleted");
    }
}
