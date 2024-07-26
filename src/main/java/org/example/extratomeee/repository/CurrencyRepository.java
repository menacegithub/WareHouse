package org.example.extratomeee.repository;

import org.example.extratomeee.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
}
