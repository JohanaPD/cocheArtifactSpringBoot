package com.project_coche.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "coches_compras")
public class PurchaseCardEntity {

    @EmbeddedId
    private CardPurchasePK cardPurchasePK;
    private Integer quantityCars;
    private Double totalPriceAllCars;

}
