package com.sgr.controller;


import com.sgr.entity.ApiResponse;
import com.sgr.entity.Equipamiento;
import com.sgr.service.EquipamientoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/equipamientos")
@AllArgsConstructor
public class EquipamientoController {

    private final EquipamientoService equipamientoService;

    @GetMapping("/")
    public ApiResponse<List<Equipamiento>> findAll(){
        return equipamientoService.findAll();
    }

    @GetMapping("/{id}")
    public ApiResponse<Equipamiento> getUser(@PathVariable Long id){
        return equipamientoService.findById(id);
    }

    @PostMapping("/")
    public ApiResponse<Equipamiento> addUser(@Valid @RequestBody Equipamiento equipamiento) {
        return equipamientoService.save(equipamiento);
    }

    @PutMapping("/")
    public ApiResponse<Equipamiento> updateUser(@Valid @RequestBody Equipamiento equipamiento) {
        return equipamientoService.update(equipamiento);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Equipamiento> deteteUser(@PathVariable Long id) {
        return equipamientoService.deleteById(id);
    }
}
