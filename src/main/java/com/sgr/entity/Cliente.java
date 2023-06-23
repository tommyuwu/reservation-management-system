package com.sgr.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="nombre")
    @NotBlank
    private String nombre;

    @Column(name="documento")
    @NotBlank
    private String documento;

    @Column(name="telefono")
    @NotBlank
    private String telefono;

    @Column(name="correo")
    @NotBlank
    @Email
    private String correo;
}
