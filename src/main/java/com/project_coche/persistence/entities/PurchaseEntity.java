package com.project_coche.persistence.entities;

import com.project_coche.domain.dto.PurchaseCarsRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "compras")
public class PurchaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_factura")
    private Integer numberBill;
    @Column(name = "clientedocumento")
    private String cardIdCustomer;
    @Column(name = "time")
    private LocalDateTime dateCustomer;
    @Column(name = "total")
    private double total;
    @Column(name = "medio_pago")
    private String paymentMethod;


    //private List<PurchaseCarsRequestDto> purchaseCarsRequestDtoList;
}
