package com.sgr.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="reserva")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="id_sala")
    @NotNull
    private Long idSala;
    
    @Column(name="id_equipamiento")
    @NotNull
    private Long idEquipameinto;

    @Column(name="id_cliente")
    @NotNull
    private Long idCliente;

    @Column(name="fecha")
    @NotNull
    private LocalDate fecha;

    @Column(name="cant_personas")
    @NotNull
    private int cantPersonas;

    @Column(name="costo")
    @NotNull
    private BigDecimal costo;
}
