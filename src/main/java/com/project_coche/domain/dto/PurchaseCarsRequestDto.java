package com.project_coche.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseCarsRequestDto {
    private Integer purchaseNumberBill;
    private Integer codeCar;
    private Integer quantityCars;
    private Double totalPriceAllCars;
}
