package org.example.extratomeee.controller;

import org.example.extratomeee.dto.CurrencyDto;
import org.example.extratomeee.model.Currency;
import org.example.extratomeee.model.Result;
import org.example.extratomeee.repository.CurrencyRepository;
import org.example.extratomeee.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CurrencyController {
    @Autowired
    private CurrencyService currencyService;
    @Autowired
    private CurrencyRepository currencyRepository;

    @GetMapping
    public List<Currency> allCurrencies() {
        return currencyService.getAllCurrencies();
    }
    @GetMapping
    public List<Currency> allCurrenciesById(@PathVariable Integer id) {
        List<Currency> list = currencyService.getCurrencyById(id);
        return list;
    }
    @PostMapping
    public Result addCurrency(@RequestBody CurrencyDto currencyDto) {
        Result currency = currencyService.createCurrency(currencyDto);
        return currency;
    }
    @PutMapping
    public Result updateCurrency(@PathVariable Integer id,@RequestBody CurrencyDto currencyDto) {
        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
        if (optionalCurrency.isPresent()) {
            Currency currency = optionalCurrency.get();
            currency.setName(currencyDto.getName());
            currencyRepository.save(currency);
            return new Result(true,"Updated currency");
        }
        return new Result(false,"not updated currency");
    }
    @DeleteMapping
    public Result deleteCurrency(@PathVariable Integer id) {
        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
        if (optionalCurrency.isPresent()) {
            currencyService.deleteCurrency(id);
            return new Result(true,"Deleted Currency");
        }
        return new Result(false,"not deleted Currency");
    }

}

