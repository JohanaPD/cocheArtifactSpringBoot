package com.project_coche.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "coche")
@Getter
@Setter
public class CardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cardId ;
    @Column(name = "marca_coche_id")
    private Integer brandCardId;
    private  String color ;
    @Column(name = "serial_chasis")
    private  String serial;
    @Column(name = "anyo_modelo", nullable = false)
    private double anyo_mod;
    private double caballos_fuerza;
    private int  n_puertas ;
    private  String referencia;
    private double precio;
    private double  cilindraje;
    private  String transmision;
    private  String tipo_combustible;
    private int num_asientos ;
    private int traccion ;
    private  String direccion;
    private  String categoria;
    private  String  ruta_imagen ;

    @ManyToOne
    @JoinColumn(name = "marca_coche_id" , insertable = false, updatable = false)
    private BrandCardEntity brandCardEntity;

}
