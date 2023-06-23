package com.sgr.service;

import com.sgr.entity.ApiResponse;
import com.sgr.entity.Cliente;

import java.util.List;

public interface ClienteService {

    ApiResponse<List<Cliente>> findAll();

    ApiResponse<Cliente> findById(Long id);

    ApiResponse<Cliente> save(Cliente usuario);

    ApiResponse<Cliente> deleteById(Long id);

    ApiResponse<Cliente> update(Cliente usuario);
}
