package com.sgr.service;

import com.sgr.entity.ApiResponse;
import com.sgr.entity.Equipamiento;
import com.sgr.repository.EquipamientoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EquipamientoServiceImpl implements EquipamientoService {

    private final EquipamientoRepository equipamientoRepository;

    @Override
    public ApiResponse<List<Equipamiento>> findAll() {
        List<Equipamiento> equipamientos = equipamientoRepository.findAll();
        if (equipamientos.isEmpty()) {
            return new ApiResponse<>(HttpStatus.NO_CONTENT, "No hay equipamientos registrados.");
        } else {
            return new ApiResponse<>(HttpStatus.OK, equipamientos);
        }
    }

    @Override
    public ApiResponse<Equipamiento> findById(Long id) {
        Optional<Equipamiento> equipamiento = equipamientoRepository.findById(id);
        return equipamiento.map(value -> new ApiResponse<>(HttpStatus.OK, value)).orElseGet(() -> new ApiResponse<>(HttpStatus.NO_CONTENT, "No se encontró el equipamiento."));
    }

    @Override
    public ApiResponse<Equipamiento> save(Equipamiento equipamiento){
        equipamiento.setId(null);
        if (equipamientoRepository.existsByDescripcion(equipamiento.getDescripcion())) return new ApiResponse<>(HttpStatus.CONFLICT, "El equipamiento ya está registrado.");
        return new ApiResponse<>(HttpStatus.OK, "Equipamiento registrado correctamente.", equipamientoRepository.save(equipamiento));
    }

    @Override
    public ApiResponse<Equipamiento> deleteById(Long id) {
        if (equipamientoRepository.findById(id).isPresent()) {
            equipamientoRepository.deleteById(id);
            return new ApiResponse<>(HttpStatus.OK, "Equipamiento eliminado.");
        } else {
            return new ApiResponse<>(HttpStatus.NOT_FOUND, "El equipamiento no existe.");
        }
    }

    @Override
    public ApiResponse<Equipamiento> update(Equipamiento equipamiento) {
        if (equipamientoRepository.findById(equipamiento.getId()).isPresent()) {
            return new ApiResponse<>(HttpStatus.OK, "Equipamiento actualizado correctamente.", equipamientoRepository.save(equipamiento));
        } else {
            return new ApiResponse<>(HttpStatus.NOT_FOUND, "El equipamiento no existe.");
        }
    }
}

