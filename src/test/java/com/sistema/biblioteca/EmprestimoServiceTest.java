package com.sistema.biblioteca;

import static org.junit.jupiter.api.Assertions.*;

import com.sistema.biblioteca.autor.AutorService;
import com.sistema.biblioteca.cliente.Cliente;
import com.sistema.biblioteca.cliente.ClienteService;
import com.sistema.biblioteca.emprestimo.EmprestimoService;
import com.sistema.biblioteca.livro.Livro;
import com.sistema.biblioteca.livro.LivroIndisponivelException;
import com.sistema.biblioteca.livro.LivroService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

public class EmprestimoServiceTest {
    @InjectMocks
    private EmprestimoService emprestimoService;

    @Mock
    private LivroService livroService;

    @Mock
    private ClienteService clienteService;

    @Mock
    private AutorService autorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa os mocks
    }

    @Test
    void deveEmprestarLivro(){

    }

    @Test
    void deveLancarExcecaoLivroIndisponivel(){
        EmprestimoService emprestimoService = new EmprestimoService();
        assertThrows(LivroIndisponivelException.class, () -> {
            emprestimoService.emprestarLivro(new Cliente("Maria", "mmaria12", LocalDate.of(2005, 6, 15), "mariap12@gmail.com"), new Livro());
        });
    }

    @Test
    void deveMostrarEmprestimosCliente(){

    }

    @Test
    void deveLancarMensagemListaClienteVazia(){
        EmprestimoService emprestimoService = new EmprestimoService();
        assertEquals("Nenhuma atividade registrada", emprestimoService.mostrarEmprestimosCliente(new Cliente("Maria", "mmaria12", LocalDate.of(2005, 6, 15), "maria@gmail.com")));
    }

    @Test
    void deveMostrarEmprestimosLivro(){

    }

    @Test
    void deveLancarMensagemListaLivroVazia(){

    }
}
