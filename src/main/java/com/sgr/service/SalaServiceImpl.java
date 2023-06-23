package com.sgr.service;

import com.sgr.entity.ApiResponse;
import com.sgr.entity.Sala;
import com.sgr.repository.SalaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SalaServiceImpl implements SalaService {

    private final SalaRepository salaRepository;

    @Override
    public ApiResponse<List<Sala>> findAll() {
        List<Sala> salas = salaRepository.findAll();
        if (salas.isEmpty()) {
            return new ApiResponse<>(HttpStatus.NO_CONTENT, "No hay salas registradas.");
        } else {
            return new ApiResponse<>(HttpStatus.OK, salas);
        }
    }

    @Override
    public ApiResponse<Sala> findById(Long id) {
        Optional<Sala> sala = salaRepository.findById(id);
        return sala.map(value -> new ApiResponse<>(HttpStatus.OK, value)).orElseGet(() -> new ApiResponse<>(HttpStatus.NO_CONTENT, "No se encontró la sala."));
    }

    @Override
    public ApiResponse<Sala> save(Sala sala){
        sala.setId(null);
        if (salaRepository.existsByNroSalaAndNombreSalon(sala.getNroSala(), sala.getNombreSalon())) return new ApiResponse<>(HttpStatus.CONFLICT, "La sala ya está registrada.");
        return new ApiResponse<>(HttpStatus.OK, "Sala registrada correctamente.", salaRepository.save(sala));
    }

    @Override
    public ApiResponse<Sala> deleteById(Long id) {
        if (salaRepository.findById(id).isPresent()) {
            salaRepository.deleteById(id);
            return new ApiResponse<>(HttpStatus.OK, "Sala eliminada.");
        } else {
            return new ApiResponse<>(HttpStatus.NOT_FOUND, "La sala no existe.");
        }
    }

    @Override
    public ApiResponse<Sala> update(Sala sala) {
        if (salaRepository.findById(sala.getId()).isPresent()) {
            return new ApiResponse<>(HttpStatus.OK, "Sala actualizada correctamente.", salaRepository.save(sala));
        } else {
            return new ApiResponse<>(HttpStatus.NOT_FOUND, "La sala no existe.");
        }
    }
}
