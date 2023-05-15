package com.sgr.service;

import java.util.List;

import com.sgr.entity.Usuario;

public interface UserService {

    List<Usuario> findAll();

    Usuario findById(int id);

    void save(Usuario usuario);

    void deleteById(int id);

    void update(Long id, Usuario usuario);
}