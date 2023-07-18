package com.github.cursospringboot.controllers;

import com.github.cursospringboot.dto.ClienteDto;
import com.github.cursospringboot.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public ResponseEntity<?> listar() {
        var listaClientes = service.listarClientes();
        return new ResponseEntity<>(listaClientes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody ClienteDto clienteDto) {
        service.criar(clienteDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
