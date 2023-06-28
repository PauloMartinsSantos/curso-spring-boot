package com.github.cursospringboot.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    /*
    Quando acessado o endereço da aplicação, ele retorna uma resposta HTTP 200, e uma mensagem: Listando clientes
     */
    @GetMapping
    public ResponseEntity<?> listar() {
        return new ResponseEntity<>("Listando clientes", HttpStatus.OK);
    }
}
