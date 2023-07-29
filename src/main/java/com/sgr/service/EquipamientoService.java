package com.sgr.service;

import com.sgr.entity.Equipamiento;
import com.sgr.entity.ApiResponse;
import java.util.List;

public interface EquipamientoService {
    ApiResponse<List<Equipamiento>> findAll();

    ApiResponse<Equipamiento> findById(Long id);

    ApiResponse<Equipamiento> save(Equipamiento equipamiento);

    ApiResponse<Equipamiento> deleteById(Long id);

    ApiResponse<Equipamiento> update(Equipamiento equipamiento);
}
