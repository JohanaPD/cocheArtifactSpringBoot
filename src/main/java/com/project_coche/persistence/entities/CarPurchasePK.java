package com.project_coche.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter @Setter
@Embeddable
public class CarPurchasePK implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "comprasnum_factura")
    private Integer purchaseNumberBill;
    @Column(name = "coche_id_vehiculo")
    private Integer codeCar;
}
