package com.sgr.service;

import com.sgr.entity.ApiResponse;
import com.sgr.entity.Reserva;
import com.sgr.repository.ReservaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;

    @Override
    public ApiResponse<List<Reserva>> findAll() {
        List<Reserva> reservas = reservaRepository.findAll();
        if (reservas.isEmpty()) {
            return new ApiResponse<>(HttpStatus.NO_CONTENT, "No hay reservas registradas.");
        } else {
            return new ApiResponse<>(HttpStatus.OK, reservas);
        }
    }

    @Override
    public ApiResponse<Reserva> findById(Long id) {
        Optional<Reserva> reserva = reservaRepository.findById(id);
        return reserva.map(value -> new ApiResponse<>(HttpStatus.OK, value)).orElseGet(() -> new ApiResponse<>(HttpStatus.NO_CONTENT, "No se encontró la reserva."));
    }

    @Override
    public ApiResponse<Reserva> save(Reserva reserva){
        reserva.setId(null);
        if (reservaRepository.existsByClienteFechaSala(reserva.getIdCliente(), reserva.getFecha(), reserva.getIdSala())) return new ApiResponse<>(HttpStatus.CONFLICT, "La sala ya está reservada para esa fecha.");
        return new ApiResponse<>(HttpStatus.OK, "Sala reservada correctamente.", reservaRepository.save(reserva));
    }

    @Override
    public ApiResponse<Reserva> deleteById(Long id) {
        if (reservaRepository.findById(id).isPresent()) {
            reservaRepository.deleteById(id);
            return new ApiResponse<>(HttpStatus.OK, "Reserva eliminada.");
        } else {
            return new ApiResponse<>(HttpStatus.NOT_FOUND, "La reserva no existe.");
        }
    }

    @Override
    public ApiResponse<Reserva> update(Reserva reserva) {
        if (reservaRepository.findById(reserva.getId()).isPresent()) {
            return new ApiResponse<>(HttpStatus.OK, "Reserva actualizada correctamente.", reservaRepository.save(reserva));
        } else {
            return new ApiResponse<>(HttpStatus.NOT_FOUND, "La reserva no existe.");
        }
    }
}
