package com.sgr.controller;


import com.sgr.entity.ApiResponse;
import com.sgr.entity.Cliente;
import com.sgr.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@AllArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping("/")
    public ApiResponse<List<Cliente>> findAll(){
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public ApiResponse<Cliente> getUser(@PathVariable Long id){
        return clienteService.findById(id);
    }

    @PostMapping("/")
    public ApiResponse<Cliente> addUser(@Valid @RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @PutMapping("/")
    public ApiResponse<Cliente> updateUser(@Valid @RequestBody Cliente cliente) {
        return clienteService.update(cliente);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Cliente> deteteUser(@PathVariable Long id) {
        return clienteService.deleteById(id);
    }
}
