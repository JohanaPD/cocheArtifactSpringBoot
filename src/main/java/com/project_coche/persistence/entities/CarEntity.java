package com.project_coche.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "coche")
@Getter
@Setter
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehiculo")
    private Integer cardId;
    @Column(name = "marca_coche_id")
    private Integer brandCardId;
    private String color;
    @Column(name = "serial_chasis")
    private String serial;
    @Column(name = "anyo_modelo", nullable = false)
    private double anyo_mod;
    private double caballos_fuerza;
    private int n_puertas;
    private String referencia;
    @Column(name = "precio", nullable = false)
    private double price;
    private double cilindraje;
    private String transmision;
    private String tipo_combustible;
    private int num_asientos;
    private int traccion;
    private String direccion;
    private String categoria;
    private String ruta_imagen;

    @ManyToOne
    @JoinColumn(name = "marca_coche_id", insertable = false, updatable = false)
    private BrandCarEntity brandCarEntity;

    @OneToMany(mappedBy = "carEntity")
    private List<PurchaseCarEntity> purchaseCarEntity;

}
