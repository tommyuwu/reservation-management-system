package com.sgr.service;

import com.sgr.entity.ApiResponse;
import com.sgr.entity.Cliente;
import com.sgr.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public ApiResponse<List<Cliente>> findAll() {
        List<Cliente> clientes = clienteRepository.findAll();
        if (clientes.isEmpty()) {
            return new ApiResponse<>(HttpStatus.NO_CONTENT, "No hay clientes registrados.");
        } else {
            return new ApiResponse<>(HttpStatus.OK, clientes);
        }
    }

    @Override
    public ApiResponse<Cliente> findById(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.map(value -> new ApiResponse<>(HttpStatus.OK, value)).orElseGet(() -> new ApiResponse<>(HttpStatus.NO_CONTENT, "No se encontró el cliente."));
    }

    @Override
    public ApiResponse<Cliente> save(Cliente cliente){
        cliente.setId(null);
        if (clienteRepository.existsByCorreo(cliente.getCorreo())) return new ApiResponse<>(HttpStatus.CONFLICT, "El email ya está registrado.");
        if (clienteRepository.existsByDocumento(cliente.getDocumento())) return new ApiResponse<>(HttpStatus.CONFLICT, "El documento ya está registrado.");
        if (clienteRepository.existsByTelefono(cliente.getTelefono())) return new ApiResponse<>(HttpStatus.CONFLICT, "El teléfono ya está registrado.");
        return new ApiResponse<>(HttpStatus.OK, "Cliente registrado correctamente.", clienteRepository.save(cliente));
    }

    @Override
    public ApiResponse<Cliente> deleteById(Long id) {
        if (clienteRepository.findById(id).isPresent()) {
            clienteRepository.deleteById(id);
            return new ApiResponse<>(HttpStatus.OK, "Cliente eliminado.");
        } else {
            return new ApiResponse<>(HttpStatus.NOT_FOUND, "El cliente no existe.");
        }
    }

    @Override
    public ApiResponse<Cliente> update(Cliente cliente) {
        if (clienteRepository.findById(cliente.getId()).isPresent()) {
            return new ApiResponse<>(HttpStatus.OK, "Cliente actualizado correctamente.", clienteRepository.save(cliente));
        } else {
            return new ApiResponse<>(HttpStatus.NOT_FOUND, "El cliente no existe.");
        }
    }
}
