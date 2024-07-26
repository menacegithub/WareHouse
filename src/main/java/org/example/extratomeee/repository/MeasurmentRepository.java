package org.example.extratomeee.repository;

import org.example.extratomeee.model.Measurement;
import org.example.extratomeee.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurmentRepository extends JpaRepository <Measurement,Integer> {
}
