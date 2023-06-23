package com.sgr.controller;

import java.util.List;

import com.sgr.entity.ApiResponse;
import com.sgr.entity.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgr.service.UsuarioService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("/")
    public ApiResponse<List<Usuario>> findAll(){
        return usuarioService.findAll();
    }

    @GetMapping("/{userId}")
    public ApiResponse<Usuario> getUser(@PathVariable Long userId){
        return usuarioService.findById(userId);
    }

    @PostMapping("/")
    public ApiResponse<Usuario> addUser(@Valid @RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @PutMapping("/")
    public ApiResponse<Usuario> updateUser(@Valid @RequestBody Usuario usuario) {
        return usuarioService.update(usuario);
    }

    @DeleteMapping("/{userId}")
    public ApiResponse<Usuario> deteteUser(@PathVariable Long userId) {
        return usuarioService.deleteById(userId);
    }
}