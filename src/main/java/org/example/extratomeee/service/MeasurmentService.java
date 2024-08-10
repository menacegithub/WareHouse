package org.example.extratomeee.service;

import org.example.extratomeee.dto.MeasurmentDto;
import org.example.extratomeee.model.Measurement;
import org.example.extratomeee.model.Result;
import org.example.extratomeee.repository.MeasurmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MeasurmentService {
    @Autowired
    private MeasurmentRepository measurmentRepository;


    public MeasurmentRepository GetMeasurmentRepository() {
        return measurmentRepository;
    }
    public MeasurmentRepository GetMeasurmentRepositoryById(Integer id) {
        Optional<Measurement> measurementOptional = measurmentRepository.findById(id);
        if (measurementOptional.isPresent()) {
            return measurmentRepository;
        }
        return null;
    }
    public Result createMeasurment(MeasurmentDto measurmentDto) {
        MeasurmentDto measurmentDto1 = new MeasurmentDto();
        measurmentDto1.setName(measurmentDto.getName());
        return new Result(true,"Created");
    }
    public Result updateMeasurment(Integer id, MeasurmentDto measurmentDto) {
        MeasurmentDto measurmentDto1 = new MeasurmentDto();
        measurmentDto1.setName(measurmentDto.getName());
        return new Result(true,"Updated");
    }
    public Result deleteMeasurment(Integer id) {
        Optional<Measurement> measurementOptional = measurmentRepository.findById(id);
        if (measurementOptional.isPresent()) {
            measurmentRepository.deleteById(id);
            return new Result(true,"Deleted");
        }
        return new Result(true,"Not deleted");
    }
}
