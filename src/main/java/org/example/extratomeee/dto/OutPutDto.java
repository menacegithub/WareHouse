package org.example.extratomeee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.extratomeee.model.Client;

import java.util.Currency;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutPutDto {
    private Integer wareHouseId;
    private Integer currencyId;
    private String factureNumber;
    private Integer code;
    private List<Client> clientId;

}
