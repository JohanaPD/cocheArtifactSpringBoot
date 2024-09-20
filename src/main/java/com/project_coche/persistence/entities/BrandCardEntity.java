package com.project_coche.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "marca_coche")
public class BrandCardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "descripcion")
    private String description;

    @OneToMany(mappedBy = "brandCardEntity", orphanRemoval = true)
    private List<CardEntity> cardEntities = new ArrayList<>();

}
