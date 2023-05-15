package com.sgr.service;

import com.sgr.dao.UserDAO;
import com.sgr.entity.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Override
    public List<Usuario> findAll() {
        return userDAO.findAll();
    }

    @Override
    public Usuario findById(Long id) {
        return userDAO.findById(id);
    }

    @Override
    public void save(Usuario usuario) {
        userDAO.save(usuario);

    }

    @Override
    public void deleteById(Long id) {
        userDAO.deleteById(id);
    }

    @Override
    public void update(Long id, Usuario usuario) {
        userDAO.update(id, usuario);
    }
}