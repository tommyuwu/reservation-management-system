package com.sgr.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name="equipamiento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipamiento {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="descripcion")
    @NotNull
    private String descripcion;

    @Column(name="costo")
    @NotNull
    private BigDecimal costo;
}