package org.example.extratomeee.controller;

import org.example.extratomeee.dto.CurrencyDto;
import org.example.extratomeee.model.Currency;
import org.example.extratomeee.model.Result;
import org.example.extratomeee.repository.CurrencyRepository;
import org.example.extratomeee.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    public Currency allCurrenciesById(@PathVariable Integer id) {
        Currency currencyById = currencyService.getCurrencyById(id);
        return currencyById;
    }

    @PostMapping
    public Result addCurrency(@RequestBody CurrencyDto currencyDto) {
        Result result = currencyService.createCurrency(currencyDto);
        return result;
        //    return currency;
    }

    @PutMapping
    public Result updateCurrency(@PathVariable Integer id, @RequestBody CurrencyDto currencyDto) {
        Result result = currencyService.updateCurrency(currencyDto, id);
        return result;
    }

    @DeleteMapping
    public Result deleteCurrency(@PathVariable Integer id) {
        Result result = currencyService.deleteCurrency(id);
        return result;
    }

}

