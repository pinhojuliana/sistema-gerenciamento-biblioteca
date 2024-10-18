package com.sistema.biblioteca;

import com.sistema.biblioteca.cliente.ClienteService;
import com.sistema.biblioteca.cliente.UsuarioInexistenteException;
import com.sistema.biblioteca.validacao_email.EmailInvalidoException;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @InjectMocks
  private ClienteService clienteService;

    @Test
    void deveCadastrarCliente(){
        clienteService.cadastrarCliente("Maria", "mmaria12", LocalDate.of(2005, 6, 15), "mariap12@gmail.com");
        assertEquals("Maria", clienteService.getClientes().get(0).getNome());
    }

    @Test
    void deveLancarExcecaoEmail(){
       assertThrows(EmailInvalidoException.class, () -> {
            clienteService.cadastrarCliente("Maria", "mmaria12", LocalDate.of(2005, 6, 15), "email_invalido");
        });
    }

    @Test
    void deveMostrarListaClientesCadastrados(){
        clienteService.cadastrarCliente("Maria", "mmaria12", LocalDate.of(2005, 6, 15), "mariap12@gmail.com");
        clienteService.cadastrarCliente("João", "joao.silva", LocalDate.of(1997, 5, 30), "silva2joao@outlook.com");

        assertEquals("mmaria12\njoao.silva", clienteService.mostrarClientesCadastrados());
    }

    @Test
    void deveLancarExcecaoClienteInexistente(){
        clienteService.cadastrarCliente("Maria", "mmaria12", LocalDate.of(2005, 6, 15), "mariap12@gmail.com");
        clienteService.cadastrarCliente("João", "joao.silva", LocalDate.of(1997, 5, 30), "silva2joao@outlook.com");

        assertThrows(UsuarioInexistenteException.class, () -> {
            clienteService.verificarCliente("juli.souza");
        });
    }

    @Test
    void pesquisaDeveRetornarCliente(){
       clienteService.cadastrarCliente("Maria", "mmaria12", LocalDate.of(2005, 6, 15), "mariap12@gmail.com");
        clienteService.cadastrarCliente("João", "joao.silva", LocalDate.of(1997, 5, 30), "silva2joao@outlook.com");

        assertEquals(clienteService.getClientes().get(0), clienteService.verificarCliente("mmaria12"));
    }
}
