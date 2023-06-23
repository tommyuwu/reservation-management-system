package com.sgr.controller;


import com.sgr.entity.ApiResponse;
import com.sgr.entity.Sala;
import com.sgr.service.SalaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/salas")
@AllArgsConstructor
public class SalaController {

    private final SalaService salaService;

    @GetMapping("/")
    public ApiResponse<List<Sala>> findAll(){
        return salaService.findAll();
    }

    @GetMapping("/{id}")
    public ApiResponse<Sala> getUser(@PathVariable Long id){
        return salaService.findById(id);
    }

    @PostMapping("/")
    public ApiResponse<Sala> addUser(@Valid @RequestBody Sala sala) {
        return salaService.save(sala);
    }

    @PutMapping("/")
    public ApiResponse<Sala> updateUser(@Valid @RequestBody Sala sala) {
        return salaService.update(sala);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Sala> deteteUser(@PathVariable Long id) {
        return salaService.deleteById(id);
    }
}
