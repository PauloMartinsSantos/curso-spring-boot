package com.github.cursospringboot.services;

import com.github.cursospringboot.models.Cliente;
import com.github.cursospringboot.repositories.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {
    @Mock
    private ClienteRepository repository;
    @InjectMocks
    private ClienteService service;

    @Test
    void testListar() {
        Cliente cliente =  Mockito.mock(Cliente.class);
        Mockito.when(repository.findAll()).thenReturn(List.of(cliente));
        service.listarClientes();
        Mockito.verify(repository, Mockito.times(1)).findAll();
    }

}
