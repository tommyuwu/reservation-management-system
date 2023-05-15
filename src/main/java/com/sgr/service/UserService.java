package com.sgr.service;

import java.util.List;

import com.sgr.entity.Usuario;

public interface UserService {

    List<Usuario> findAll();

    Usuario findById(Long id);

    void save(Usuario usuario);

    void deleteById(Long id);

    void update(Long id, Usuario usuario);
}