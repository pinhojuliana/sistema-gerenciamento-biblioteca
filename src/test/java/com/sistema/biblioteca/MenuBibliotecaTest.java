package com.sistema.biblioteca;

import com.sistema.biblioteca.entity.pessoa.autor.AutorService;
import com.sistema.biblioteca.entity.biblioteca.MenuBiblioteca;
import com.sistema.biblioteca.entity.pessoa.cliente.ClienteService;
import com.sistema.biblioteca.entity.emprestimo.EmprestimoService;
import com.sistema.biblioteca.entity.livro.LivroService;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class MenuBibliotecaTest {

    @InjectMocks
    MenuBiblioteca menuBiblioteca;

    @Mock
    LivroService livroService;
    @Mock
    EmprestimoService emprestimoService;
    @Mock
    AutorService autorService;
    @Mock
    ClienteService clienteService;
    @Mock
    Scanner scanner;

    @Test
    void deveMostrarOpcoesMenu(){

    }

    @Test
    void deveApresentarMensagemOpcaoInvalida(){
        // Redireciona a saída do console para um stream de bytes
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Executa o método com opção inválida
        menuBiblioteca.executarAcaoMenu(9);

        // Verifica a saída no console
        assertEquals("Opção inválida. Por favor, insira uma opção válida.\n", outContent.toString());

        // Restaura a saída padrão do sistema
        System.setOut(System.out);
    }

    @Nested
    class opcaoMostrarLivrosDisponiveis{
        @Test
        void deveMostrarLivrosDisponíveis(){
        }


    }

    @Nested
    class pegarLivroEmprestado{

    }

    @Nested
    class cadastroUsuario{

    }

    @Nested
    class cadastroLivro{

    }

    @Nested
    class pesquisaLivro{

    }

    @Nested
    class emprestimosCliente{

    }

    @Nested
    class emprestimosLivro{

    }



}
