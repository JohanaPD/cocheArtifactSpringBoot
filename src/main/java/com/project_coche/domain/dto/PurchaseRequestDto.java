package com.project_coche.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class PurchaseRequestDto {
    private Integer numberBill;
    private String cardIdCustomer;
    private LocalDateTime dateCustomer;
    private double total;
    private String paymentMethod;
    private List<PurchaseCarsRequestDto> purchaseCarsRequestDtoList;

}
