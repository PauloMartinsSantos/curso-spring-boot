package com.github.cursospringboot.services;

import com.github.cursospringboot.dto.ClienteDto;
import com.github.cursospringboot.models.Cliente;
import com.github.cursospringboot.repositories.ClienteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

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
        List<Cliente> lista = service.listarClientes();
        Assertions.assertEquals(1, lista.size());
//        service.listarClientes();
        Mockito.verify(repository, Mockito.times(1)).findAll();
    }

    @Test
    void testCriar() {

        ClienteDto clienteDto = Mockito.mock(ClienteDto.class);
        UUID uuidMock = UUID.randomUUID();
        Cliente clienteMock = new Cliente(uuidMock,"Paulo","paulo.martins@viavarejo.com.br");
        Mockito.when(repository.save(Mockito.any(Cliente.class))).thenReturn(clienteMock);
        var clienteSalvo = service.criar(clienteDto);
        Assertions.assertNotNull(clienteSalvo);
        Assertions.assertEquals("Paulo",clienteSalvo.getNome());
        Assertions.assertNotNull(clienteSalvo.getEmail());
        Assertions.assertEquals(uuidMock,clienteSalvo.getId());
        Mockito.verify(repository, Mockito.times(1)).save(Mockito.any(Cliente.class));
    }

}
