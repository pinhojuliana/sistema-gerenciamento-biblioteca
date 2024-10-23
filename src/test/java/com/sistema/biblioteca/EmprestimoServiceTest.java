package com.sistema.biblioteca;

import static org.junit.jupiter.api.Assertions.*;

import com.sistema.biblioteca.entity.pessoa.autor.Autor;
import com.sistema.biblioteca.entity.pessoa.cliente.Cliente;
import com.sistema.biblioteca.entity.emprestimo.Emprestimo;
import com.sistema.biblioteca.entity.emprestimo.EmprestimoService;
import com.sistema.biblioteca.entity.livro.GeneroLiterario;
import com.sistema.biblioteca.entity.livro.Livro;
import com.sistema.biblioteca.entity.livro.LivroIndisponivelException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class EmprestimoServiceTest {

    @InjectMocks
    private EmprestimoService emprestimoService;

    @Test
    void deveEmprestarLivro(){
        Cliente cliente = new Cliente("Maria", "mmaria12", LocalDate.of(2005, 6, 15), "mariap12@gmail.com");
        Livro livro = new Livro("Iracema", new Autor("José de Alencar"), GeneroLiterario.ROMANCE);
        Emprestimo emprestimo = new Emprestimo(livro, cliente);
        emprestimoService.emprestarLivro(cliente, livro);
        assertEquals("Iracema", cliente.getEmprestimos().get(0).getLivro().getTitulo());
        assertEquals("mmaria12", livro.getEmprestimosLivro().get(0).getCliente().getNomeUsuario());
        assertEquals(LocalDate.now(), emprestimo.getDataEmprestimo());
    }

    @Test
    void deveLancarExcecaoLivroIndisponivel(){
        assertThrows(LivroIndisponivelException.class, () -> {
            emprestimoService.emprestarLivro(new Cliente("Maria", "mmaria12", LocalDate.of(2005, 6, 15), "mariap12@gmail.com"), new Livro());
        });
    }

    @Test
    void deveMostrarEmprestimosCliente(){
        Cliente cliente = new Cliente("Maria", "mmaria12", LocalDate.of(2005, 6, 15), "mariap12@gmail.com");
        Livro livro = new Livro("Iracema", new Autor("José de Alencar"), GeneroLiterario.ROMANCE);
        Emprestimo emprestimo = new Emprestimo(livro, cliente);
        Livro livro1 = new Livro("O Pequeno Principe", new Autor("Antoine de Saint-Exupéry"), GeneroLiterario.FANTASIA);
        emprestimoService.emprestarLivro(cliente, livro);
        emprestimoService.emprestarLivro(cliente, livro1);
        assertEquals("Livro: Iracema, Data: " + LocalDate.now() + "\nLivro: O Pequeno Principe, Data: " + LocalDate.now(), emprestimoService.mostrarEmprestimosCliente(cliente));
    }

    @Test
    void deveLancarMensagemListaClienteVazia(){
        assertEquals("Nenhuma atividade registrada", emprestimoService.mostrarEmprestimosCliente(new Cliente("Maria", "mmaria12", LocalDate.of(2005, 6, 15), "maria@gmail.com")));
    }

    @Test
    void deveMostrarEmprestimosLivro(){
        Livro livro = new Livro("Iracema", new Autor("José de Alencar"), GeneroLiterario.ROMANCE);
        Cliente cliente = new Cliente("Maria", "mmaria12", LocalDate.of(2005, 6, 15), "mariap12@gmail.com");
        emprestimoService.emprestarLivro(cliente, livro);
        assertEquals("Cliente: mmaria12, Data: " + LocalDate.now(), emprestimoService.mostrarEmprestimosLivro(livro));
    }

    @Test
    void deveLancarExcecaoLivroIndisponivelEmprestimo(){
        Livro livro = new Livro("Iracema", new Autor("José de Alencar"), GeneroLiterario.ROMANCE);
        Cliente cliente = new Cliente("Maria", "mmaria12", LocalDate.of(2005, 6, 15), "mariap12@gmail.com");
        Cliente cliente1 = new Cliente("João", "joao.silva", LocalDate.of(1997, 5, 30), "silva2joao@outlook.com");
        emprestimoService.emprestarLivro(cliente, livro);
        assertThrows(LivroIndisponivelException.class, () -> {
            emprestimoService.emprestarLivro(cliente1, livro);
        });
    }

    @Test
    void deveLancarMensagemListaLivroVazia(){
        Livro livro = new Livro("Iracema", new Autor("José de Alencar"), GeneroLiterario.ROMANCE);
        assertEquals("Nenhuma atividade registrada", emprestimoService.mostrarEmprestimosLivro(livro));
    }
}
