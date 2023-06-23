package com.sgr.service;

import com.sgr.entity.ApiResponse;
import com.sgr.entity.Sala;

import java.util.List;

public interface SalaService {

    ApiResponse<List<Sala>> findAll();

    ApiResponse<Sala> findById(Long id);

    ApiResponse<Sala> save(Sala sala);

    ApiResponse<Sala> deleteById(Long id);

    ApiResponse<Sala> update(Sala sala);
}
