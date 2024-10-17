package com.sistema.biblioteca;

import com.sistema.biblioteca.cliente.ClienteService;
import com.sistema.biblioteca.cliente.UsuarioInexistenteException;
import com.sistema.biblioteca.validacao_email.EmailInvalidoException;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ClienteServiceTest {

    /*private ClienteService clienteService;

    @BeforeEach
    void criaObjetoClienteService(){
        ClienteService clienteService = new ClienteService();
    }
    */

    @Test
    void deveCadastrarCliente(){
        ClienteService clienteService = new ClienteService();
        clienteService.cadastrarCliente("Maria", "mmaria12", LocalDate.of(2005, 6, 15), "mariap12@gmail.com");

        assertEquals("Maria", clienteService.getClientes().get(0).getNome());
    }

    @Test
    void deveLancarExcecaoEmail(){
        ClienteService clienteService = new ClienteService();

        assertThrows(EmailInvalidoException.class, () -> {
            clienteService.cadastrarCliente("Maria", "mmaria12", LocalDate.of(2005, 6, 15), "email_invalido");
        });
    }

    @Test
    void deveMostrarListaClientesCadastrados(){
        ClienteService clienteService = new ClienteService();
        clienteService.cadastrarCliente("Maria", "mmaria12", LocalDate.of(2005, 6, 15), "mariap12@gmail.com");
        clienteService.cadastrarCliente("João", "joao.silva", LocalDate.of(1997, 5, 30), "silva2joao@outlook.com");

        assertEquals("mmaria12\njoao.silva", clienteService.mostrarClientesCadastrados());
    }

    @Test
    void deveLancarExcecaoClienteInexistente(){
        ClienteService clienteService = new ClienteService();
        clienteService.cadastrarCliente("Maria", "mmaria12", LocalDate.of(2005, 6, 15), "mariap12@gmail.com");
        clienteService.cadastrarCliente("João", "joao.silva", LocalDate.of(1997, 5, 30), "silva2joao@outlook.com");

        assertThrows(UsuarioInexistenteException.class, () -> {
            clienteService.verificarCliente("juli.souza");
        });
    }

    @Test
    void deveRetornarClientePesquisa(){
        ClienteService clienteService = new ClienteService();
        clienteService.cadastrarCliente("Maria", "mmaria12", LocalDate.of(2005, 6, 15), "mariap12@gmail.com");
        clienteService.cadastrarCliente("João", "joao.silva", LocalDate.of(1997, 5, 30), "silva2joao@outlook.com");

        assertEquals(clienteService.getClientes().get(0), clienteService.verificarCliente("mmaria12"));
    }
}
