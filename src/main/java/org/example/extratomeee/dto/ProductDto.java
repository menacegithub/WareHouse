package org.example.extratomeee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductDto {


    private String name;
    private Integer categoryId;
    private Integer attachment;
    private String code;
    private Integer measurement;
}
