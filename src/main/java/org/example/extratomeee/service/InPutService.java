package org.example.extratomeee.service;

import org.example.extratomeee.dto.InPutDto;
import org.example.extratomeee.model.*;
import org.example.extratomeee.repository.CurrencyRepository;
import org.example.extratomeee.repository.InPutRepository;
import org.example.extratomeee.repository.SupplierRepository;
import org.example.extratomeee.repository.WareHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InPutService {

    @Autowired
    InPutRepository inPutRepository;
    @Autowired
    CurrencyRepository currencyRepository;
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    WareHouseRepository wareHouseRepository;

    public List<Input> getAllInput(){
        List<Input> list = inPutRepository.findAll();
        return list;
    }

    public Input getInputById(Integer id){
        Optional<Input> inputOptional = inPutRepository.findById(id);
        return inputOptional.get();
    }

    public Result createInput(InPutDto inPutDto){
        Input input = new Input();
        Optional<Currency> optionalCurrency = currencyRepository.findById(inPutDto.getCurrency());
        Currency currency = optionalCurrency.get();
        input.setCurrency((List<Currency>) currency);

        Optional<Supplier> supplierOptional = supplierRepository.findById(inPutDto.getSupplier());
        Supplier supplier = supplierOptional.get();
        input.setSupplier(supplier);

        Optional<WareHouse> wareHouseOptional = wareHouseRepository.findById(inPutDto.getWarehouse());
        WareHouse wareHouse = wareHouseOptional.get();
        input.setWarehouse((List<WareHouse>) wareHouse);

        input.setFactureNumber(inPutDto.getFactureNumber());
        input.setCode(inPutDto.getCode());
        inPutRepository.save(input);
        return new Result(true,"Successfully created aka" );
    }

    public Result updateInput(Integer id, InPutDto inPutDto){
        Optional<Input> optionalInput = inPutRepository.findById(id);
        if(optionalInput.isPresent()){
            Input input = optionalInput.get();
            Optional<Currency> optionalCurrency = currencyRepository.findById(inPutDto.getCurrency());
            Currency currency = optionalCurrency.get();
            input.setCurrency((List<Currency>) currency);

            Optional<Supplier> supplierOptional = supplierRepository.findById(inPutDto.getSupplier());
            Supplier supplier = supplierOptional.get();
            input.setSupplier(supplier);

            Optional<WareHouse> wareHouseOptional = wareHouseRepository.findById(inPutDto.getWarehouse());
            WareHouse wareHouse = wareHouseOptional.get();
            input.setWarehouse((List<WareHouse>) wareHouse);

            input.setFactureNumber(inPutDto.getFactureNumber());
            input.setCode(inPutDto.getCode());
            inPutRepository.save(input);
            return new Result(true,"Successfully updated aka");
        }
        return new Result(false,"Not updated");
    }
    public Result deleteInput(Integer id){
        inPutRepository.deleteById(id);
        return new Result(true,"Successfully deleted aka");

    }
}
