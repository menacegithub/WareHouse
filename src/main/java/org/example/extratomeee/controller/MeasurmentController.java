package org.example.extratomeee.controller;

import org.example.extratomeee.dto.MeasurmentDto;
import org.example.extratomeee.model.Result;
import org.example.extratomeee.service.MeasurmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MeasurmentController {
    @Autowired
    MeasurmentService measurmentService;
    @GetMapping
    public MeasurmentService getMeasurmentService() {
        return (MeasurmentService) measurmentService.GetMeasurmentRepository();
    }
    @GetMapping
    public MeasurmentService getMeasurmentServicebyId(@PathVariable Integer id) {
        return (MeasurmentService) measurmentService.GetMeasurmentRepositoryById(id);
    }

    //  xato Http

    @PostMapping
    public Result createMeasurment(@RequestBody MeasurmentDto measurmentDto) {
        Result measurment = measurmentService.createMeasurment(measurmentDto);
        return measurment;
    }
     // xato http   update da integer id kelishi kerak
    @PutMapping
    public Result updateMeasurment(@PathVariable Integer id,@RequestBody MeasurmentDto measurmentDto) {
        Result result = measurmentService.updateMeasurment(id,measurmentDto);
        return result;
    }

    // xato  delete da faqat id boladi

    @DeleteMapping
    public Result deleteMeasurment(@PathVariable Integer id) {
        Result measurment = measurmentService.deleteMeasurment(id);
        return measurment;
    }
}
