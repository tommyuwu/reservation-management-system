package com.sgr.controller;


import com.sgr.entity.ApiResponse;
import com.sgr.entity.Reserva;
import com.sgr.service.ReservaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@AllArgsConstructor
public class ReservaController {

    private final ReservaService reservaService;

    @GetMapping("/")
    public ApiResponse<List<Reserva>> findAll(){
        return reservaService.findAll();
    }

    @GetMapping("/{id}")
    public ApiResponse<Reserva> getUser(@PathVariable Long id){
        return reservaService.findById(id);
    }

    @PostMapping("/")
    public ApiResponse<Reserva> addUser(@Valid @RequestBody Reserva reserva) {
        return reservaService.save(reserva);
    }

    @PutMapping("/")
    public ApiResponse<Reserva> updateUser(@Valid @RequestBody Reserva reserva) {
        return reservaService.update(reserva);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Reserva> deteteUser(@PathVariable Long id) {
        return reservaService.deleteById(id);
    }
}

