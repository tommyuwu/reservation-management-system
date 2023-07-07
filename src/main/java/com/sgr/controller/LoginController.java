package com.sgr.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgr.entity.ApiResponse;
import com.sgr.entity.Usuario;
import com.sgr.service.UsuarioService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/login")
@AllArgsConstructor
public class LoginController {

	private final UsuarioService usuarioService;
	
	@PostMapping("/")
    public ApiResponse<Usuario> addUser(@Valid @RequestBody Usuario usuario) {
        return usuarioService.login(usuario);
    }

}
