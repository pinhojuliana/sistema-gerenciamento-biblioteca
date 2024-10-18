package com.sistema.biblioteca;

import static org.junit.jupiter.api.Assertions.*;

import com.sistema.biblioteca.autor.Autor;
import com.sistema.biblioteca.cliente.Cliente;
import com.sistema.biblioteca.emprestimo.EmprestimoService;
import com.sistema.biblioteca.livro.GeneroLiterario;
import com.sistema.biblioteca.livro.Livro;
import com.sistema.biblioteca.livro.LivroIndisponivelException;
import com.sistema.biblioteca.livro.LivroService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class LivroServiceTest {
    @InjectMocks
    LivroService livroService;

    @InjectMocks
    EmprestimoService emprestimoService;

    @Test
    void deveCadastrarLivro(){
        livroService.cadastrarLivro("1984", new Autor("George Orwell"), GeneroLiterario.FICCAO_CIENTIFICA);
        livroService.cadastrarLivro("Verdadeiro Evangelho", new Autor("Paul Washer"), GeneroLiterario.RELIGIOSO);
        assertEquals("1984", livroService.getLivros().get(0).getTitulo());
        assertEquals("Verdadeiro Evangelho", livroService.getLivros().get(1).getTitulo());
    }

    @Test
    void deveMostratLivrosDisponiveis(){
        livroService.cadastrarLivro("1984", new Autor("George Orwell"), GeneroLiterario.FICCAO_CIENTIFICA);
        livroService.cadastrarLivro("Verdadeiro Evangelho", new Autor("Paul Washer"), GeneroLiterario.RELIGIOSO);
        Livro livro = new Livro("Trabalho Focado", new Autor("Carl Newport"), GeneroLiterario.DESENVOLVIMENTO_PESSOAL);
        livroService.getLivros().add(livro);

        assertEquals("1984\nVerdadeiro Evangelho\nTrabalho Focado", livroService.mostrarLivrosDisponiveis());

        emprestimoService.emprestarLivro(new Cliente("Maria", "mmaria12", LocalDate.of(2005, 6, 15), "mariap12@gmail.com"), livro);
        assertEquals("1984\nVerdadeiro Evangelho", livroService.mostrarLivrosDisponiveis());

    }

    @Test
    void deveExibirMensagemListaVazia(){
        assertEquals("Nenhum livro disponível", livroService.mostrarLivrosDisponiveis());
    }

    @Test
    void deveRetornarLivro(){
        Autor autor = new Autor("George Orwell");
        livroService.cadastrarLivro("1984", autor, GeneroLiterario.FICCAO_CIENTIFICA);
        livroService.cadastrarLivro("Verdadeiro Evangelho", new Autor("Paul Washer"), GeneroLiterario.RELIGIOSO);
        assertEquals("1984", livroService.verificarCadastroLivro("1984", autor).getTitulo());
    }

    @Test
    void deveLancarExcecaoLivroIndisponivel(){
        Autor autor = new Autor("Agatha Cristhie");
        livroService.cadastrarLivro("1984", autor, GeneroLiterario.FICCAO_CIENTIFICA);
        livroService.cadastrarLivro("Verdadeiro Evangelho", new Autor("Paul Washer"), GeneroLiterario.RELIGIOSO);
        assertThrows(LivroIndisponivelException.class, ()->{
            livroService.verificarCadastroLivro("Treze a mesa", autor);
        });
    }

    @Test
    void pesquisaDeveRetornarLivro(){
        Autor autor = new Autor("George Orwell");
        livroService.cadastrarLivro("1984", autor, GeneroLiterario.FICCAO_CIENTIFICA);
        assertEquals("1984", livroService.pesquisarLivroTitulo("1984").getTitulo());
    }

    @Test
    void pesquisaDeveLancarExcecaoLivroIndisponivel(){
        livroService.cadastrarLivro("1984", new Autor("George Orwell"), GeneroLiterario.FICCAO_CIENTIFICA);
        livroService.cadastrarLivro("Assassinato no Expresso do Oriente", new Autor("Agatha Cristhie"), GeneroLiterario.ROMANCE_POLICIAL);
        livroService.cadastrarLivro("O Pequeno Principe", new Autor("Antoine de Saint-Exupéry"), GeneroLiterario.FANTASIA);
        livroService.cadastrarLivro("Verdadeiro Evangelho", new Autor("Paul Washer"), GeneroLiterario.RELIGIOSO);
        livroService.cadastrarLivro("Trabalho Focado", new Autor("Carl Newport"), GeneroLiterario.DESENVOLVIMENTO_PESSOAL);
        livroService.cadastrarLivro("Iracema", new Autor("José de Alencar"), GeneroLiterario.ROMANCE);

        assertThrows(LivroIndisponivelException.class, () -> {
            livroService.pesquisarLivroTitulo("Admirável mundo novo");
        });
    }

    @Test
    void deveRetornarLivrosGeneroLiterario(){
        livroService.cadastrarLivro("Admirável mundo novo", new Autor("Aldous Huxley"), GeneroLiterario.FICCAO_CIENTIFICA);
        livroService.cadastrarLivro("1984", new Autor("George Orwell"), GeneroLiterario.FICCAO_CIENTIFICA);
        livroService.cadastrarLivro("Assassinato no Expresso do Oriente", new Autor("Agatha Cristhie"), GeneroLiterario.ROMANCE_POLICIAL);
        livroService.cadastrarLivro("O Pequeno Principe", new Autor("Antoine de Saint-Exupéry"), GeneroLiterario.FANTASIA);

        assertEquals("Admirável mundo novo\n1984", livroService.pesquisarLivroGenero(GeneroLiterario.FICCAO_CIENTIFICA));
    }

}
