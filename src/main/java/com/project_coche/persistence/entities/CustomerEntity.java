package com.project_coche.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cliente")
public class CustomerEntity {
    @Id
    @Column(name = "documento")
    private String cardId;
    @Column(name = "nombre_completo")
    private String firstName;
    @Column(name = "correo")
    private String email;
    @Column(name = "movil")
    private double numberPhone;
    @Column(name = "activo")
    private Integer active;
    @Column(name = "contrasenya")
    private String password;

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "active=" + active +
                ", cardId='" + cardId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", numberPhone=" + numberPhone +
                ", password='" + password + '\'' +
                '}';
    }
}
