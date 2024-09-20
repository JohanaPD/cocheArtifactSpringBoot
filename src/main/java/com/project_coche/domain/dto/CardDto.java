package com.project_coche.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardDto {
    private Integer id_vehiculo;
    private Integer marca_coche_id;
    private String color;
    private String serial_chasis;
    private double anyo_modelo;
    private double caballos_fuerza;
    private Integer n_puertas;
    private String referencia;
    private double precio;
    private double cilindraje;
    private String transmision;
    private String tipo_combustible;
    private Integer num_asientos;
    private Integer traccion;
    private String direccion;
    private String categoria;
    private String ruta_imagen;

}
