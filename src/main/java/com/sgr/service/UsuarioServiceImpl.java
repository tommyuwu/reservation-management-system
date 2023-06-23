package com.sgr.service;

import com.sgr.entity.ApiResponse;
import com.sgr.entity.Usuario;
import com.sgr.repository.UsuarioRepository;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public ApiResponse<List<Usuario>> findAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        if (usuarios.isEmpty()) {
            return new ApiResponse<>(HttpStatus.NO_CONTENT, "No hay usuarios.");
        } else {
            return new ApiResponse<>(HttpStatus.OK, usuarios);
        }
    }

    @Override
    public ApiResponse<Usuario> findById(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.map(value -> new ApiResponse<>(HttpStatus.OK, value)).orElseGet(() -> new ApiResponse<>(HttpStatus.NO_CONTENT, "No se encontró el usuario."));
    }

    @Override
    public ApiResponse<Usuario> save(Usuario usuario){
        usuario.setId(null);
        if (usuarioRepository.existsByEmail(usuario.getEmail())) return new ApiResponse<>(HttpStatus.CONFLICT, "El email ya está registrado.");
        if (usuarioRepository.existsByUsername(usuario.getUsername())) return new ApiResponse<>(HttpStatus.CONFLICT, "Usuario no disponible.");
        if (usuarioRepository.existsByPassword(usuario.getPassword())) return new ApiResponse<>(HttpStatus.CONFLICT, "Contraseña no disponible.");
        return new ApiResponse<>(HttpStatus.OK, "Usuario registrado correctamente.", usuarioRepository.save(usuario));
    }

	@Override
    public ApiResponse<Usuario> deleteById(Long id) {
        if (usuarioRepository.findById(id).isPresent()) {
            usuarioRepository.deleteById(id);
            return new ApiResponse<>(HttpStatus.OK, "Usuario eliminado.");
        } else {
            return new ApiResponse<>(HttpStatus.NOT_FOUND, "El usuario no existe.");
        }
    }

    @Override
    public ApiResponse<Usuario> update(Usuario usuario) {
        if (usuarioRepository.findById(usuario.getId()).isPresent()) {
            return new ApiResponse<>(HttpStatus.OK, "Usuario actualizado correctamente.", usuarioRepository.save(usuario));
        } else {
            return new ApiResponse<>(HttpStatus.NOT_FOUND, "El usuario no existe.");
        }
    }
}