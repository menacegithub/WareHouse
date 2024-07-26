package org.example.extratomeee.service;

import org.example.extratomeee.dto.CurrencyDto;
import org.example.extratomeee.model.Currency;
import org.example.extratomeee.model.Result;
import org.example.extratomeee.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {
    @Autowired
    private CurrencyRepository currencyRepository;

    public List<Currency> getAllCurrencies() {
        return currencyRepository.findAll();
    }

    public Currency getCurrencyById(Integer id) {
        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
        if (optionalCurrency.isPresent()) {
            return  optionalCurrency.get();
        }
        return null;
    }
    public Result createCurrency(CurrencyDto currencyDto) {

        Currency currency = new Currency();
            currency.setName(currencyDto.getName());
            currencyRepository.save(currency);
            return new Result(true, "Currency created");


    }

    public Result updateCurrency(CurrencyDto currencyDto, Integer id) {
        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
        if (optionalCurrency.isPresent()) {
            Currency currency = optionalCurrency.get();
            currency.setName(currencyDto.getName());
            currencyRepository.save(currency);
            return new Result(true, "Currency updated");
        }
        return new Result(false, "Currency not found");
    }
    public Result deleteCurrency(Integer id) {
        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
        if (optionalCurrency.isPresent()) {
            currencyRepository.delete(optionalCurrency.get());
            return new Result(true, "Currency deleted");
        }
        return new Result(false, "Currency not found");
    }
}
