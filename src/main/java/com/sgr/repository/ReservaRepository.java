package com.sgr.repository;

import com.sgr.entity.Reserva;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    @Query(value = "select exists (select 1 from reserva as r where r.id_cliente = :cliente and r.fecha = :fecha and r.id_sala = :sala)", nativeQuery = true)
    boolean existsByClienteFechaSala(@Param("cliente") Long cliente, @Param("fecha") LocalDate fecha, @Param("sala") Long sala);

}