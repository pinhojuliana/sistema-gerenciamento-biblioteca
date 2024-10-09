package com.sistema.biblioteca.livro;

import com.sistema.biblioteca.autor.Autor;
import com.sistema.biblioteca.cliente.Cliente;
import com.sistema.biblioteca.emprestimo.Emprestimo;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class LivroService {
    private List<Livro> livros;

    public LivroService(){
        this.livros = new ArrayList<>();
    }

    public void cadastrarLivro(String titulo, Autor autor, GeneroLiterario generoLiterario){
        Livro livro = new Livro(titulo, autor, generoLiterario);
        livro.setDataAtualizacao(LocalDate.now());
        livros.add(livro);
    }

    public String mostrarLivrosDisponiveis(){
        return livros.stream()
                .map(Livro::getTitulo)
                .collect(Collectors.joining("\n"));
    }


    public Livro verificarCadastroLivro(String titulo, Autor autor) {
        return livros.stream()
                .filter(l -> l.getTitulo().equalsIgnoreCase(titulo) && l.getAutor().equals(autor))
                .findFirst()
                .orElse(null);
    }

    public Livro pesquisarLivroTitulo(String tituloLivro) throws LivroIndisponivelException{
        return livros.stream()
                .filter(l -> l.getTitulo().equalsIgnoreCase(tituloLivro))
                .findFirst()
                .orElseThrow(LivroIndisponivelException::new);
    }

    public String pesquisarLivroGenero(GeneroLiterario generoLiterario){
       return  livros.stream()
                .filter(l -> l.getGeneroLiterario().equals(generoLiterario))
               .map(Livro::getTitulo)
                .collect(Collectors.joining("\n"));
    }
}
