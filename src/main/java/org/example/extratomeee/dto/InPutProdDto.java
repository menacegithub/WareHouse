package org.example.extratomeee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.extratomeee.model.Input;
import org.example.extratomeee.model.Product;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InPutProdDto {
    private List<Product> product;
    private Integer amount;
    private Double price;
    private Timestamp expireDate;
    private Input input;
}
