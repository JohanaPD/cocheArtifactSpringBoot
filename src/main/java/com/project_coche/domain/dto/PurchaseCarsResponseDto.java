package com.project_coche.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseCarsResponseDto {
    private String referenceCard;
    private Integer quantity;
    private double total;
}
