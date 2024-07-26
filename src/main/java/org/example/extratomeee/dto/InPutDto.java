package org.example.extratomeee.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.extratomeee.model.Currency;
import org.example.extratomeee.model.Supplier;
import org.example.extratomeee.model.WareHouse;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class InPutDto {
    private Integer warehouse;
    private Integer supplier;
    private Integer currency;
    private String factureNumber;
    private String code;

}
