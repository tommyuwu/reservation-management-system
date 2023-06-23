package com.sgr.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name="sala")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sala {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="nro_sala")
    @NotNull
    private int nroSala;

    @Column(name="nombre_salon")
    @NotBlank
    private String nombreSalon;

    @Column(name="direccion")
    @NotBlank
    private String direccion;

    @Column(name="costo_persona")
    @NotNull
    private BigDecimal costoPorPersona;
}
