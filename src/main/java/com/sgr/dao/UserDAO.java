package com.sgr.dao;

import java.util.List;

import com.sgr.entity.Usuario;

public interface UserDAO {

    List<Usuario> findAll();

    Usuario findById(Long id);

    String save(Usuario usuario);

    void deleteById(Long id);

    void update(Long id, Usuario usuario);
}