package org.example.extratomeee.controller;

import org.example.extratomeee.dto.OutPutDto;
import org.example.extratomeee.model.OutPut;
import org.example.extratomeee.model.Result;
import org.example.extratomeee.service.OutPutServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/output")
public class OutPutController {

    @Autowired
    OutPutServise outPutServise;

    @GetMapping
    public List<OutPut> getOutAll() {
        List<OutPut> list= outPutServise.getallOutPuts();
        return list;
    }

    @PostMapping
    public Result addOutPut(@RequestBody OutPutDto outPutDto) {
        Result result = outPutServise.createOutPut(outPutDto);
        return result;
    }

    @PutMapping
    public Result updateOutPut(@PathVariable Integer id,@RequestBody OutPutDto outPutDto) {
        Result result = outPutServise.updateOutPut(id,outPutDto);
        return result;
    }

    // faqat id boladi


    @DeleteMapping
    public Result deleteOutPut(@PathVariable Integer id, @RequestBody OutPutDto outPutDto) {
        Result delete = outPutServise.deleteOutPut(id);
        return delete;
    }
}
