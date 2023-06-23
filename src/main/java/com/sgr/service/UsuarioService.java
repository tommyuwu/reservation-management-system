package com.sgr.service;

import java.util.List;

import com.sgr.entity.ApiResponse;
import com.sgr.entity.Usuario;

public interface UsuarioService {

    ApiResponse<List<Usuario>> findAll();

    ApiResponse<Usuario> findById(Long id);

    ApiResponse<Usuario> save(Usuario usuario);

    ApiResponse<Usuario> deleteById(Long id);

    ApiResponse<Usuario> update(Usuario usuario);
}