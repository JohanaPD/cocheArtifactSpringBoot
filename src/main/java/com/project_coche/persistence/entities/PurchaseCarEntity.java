package com.project_coche.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "coches_compras")
public class PurchaseCarEntity {

    @EmbeddedId
    private CarPurchasePK carPurchasePK;
    @Column(name = "cantidad")
    private Integer quantityCars;
    @Column(name = "total")
    private Double totalPriceAllCars;

    @ManyToOne
    @MapsId(value = "purchaseNumberBill")
    @JoinColumn(name = "comprasnum_factura", insertable = false, updatable = false)
    private PurchaseEntity purchaseEntity;

    @ManyToOne
    @JoinColumn(name = "coche_id_vehiculo", insertable = false, updatable = false)
    private CarEntity carEntity;

}
