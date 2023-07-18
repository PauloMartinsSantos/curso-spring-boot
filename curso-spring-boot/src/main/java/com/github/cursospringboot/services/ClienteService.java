package com.github.cursospringboot.services;

import com.github.cursospringboot.dto.ClienteDto;
import com.github.cursospringboot.models.Cliente;
import com.github.cursospringboot.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;
    public List<Cliente> listarClientes() {
        return repository.findAll();
    }
    public void criar(ClienteDto dto){
        Cliente cliente = Cliente.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .build();
        repository.save(cliente);
    }
}
