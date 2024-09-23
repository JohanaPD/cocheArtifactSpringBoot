package com.project_coche.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardDto {
    private Integer id_vehiculo;
    private Integer brandCardId;
    private String color;
    private String serial;
    private double anyo_mod;
    private double caballos_fuerza;
    private Integer n_puertas;
    private String referencia;
    private double price;
    private double cilindraje;
    private String transmision;
    private String tipo_combustible;
    private Integer num_asientos;
    private Integer traccion;
    private String direccion;
    private String categoria;
    private String ruta_imagen;
}
