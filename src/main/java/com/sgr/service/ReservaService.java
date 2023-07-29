package com.sgr.service;

import com.sgr.entity.ApiResponse;
import com.sgr.entity.Reserva;

import java.util.List;

public interface ReservaService {

    ApiResponse<List<Reserva>> findAll();

    ApiResponse<Reserva> findById(Long id);

    ApiResponse<Reserva> save(Reserva reserva);

    ApiResponse<Reserva> deleteById(Long id);

    ApiResponse<Reserva> update(Reserva reserva);
}