package com.sistema.biblioteca.livro;

import com.sistema.biblioteca.autor.Autor;
import com.sistema.biblioteca.emprestimo.Emprestimo;
import com.sistema.biblioteca.formatador_data.FormatadorData;
import lombok.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livro {
    private UUID id;
    private String titulo;
    private Autor autor;
    private boolean disponivel;
    private LocalDate dataCadastro;
    private LocalDate dataAtualizacao;
    private GeneroLiterario generoLiterario;
    private List<Emprestimo> emprestimosLivro;
    //private int quantidade;

    public Livro(String titulo, Autor autor, GeneroLiterario generoLiterario){
        this.id = UUID.randomUUID();
        this.titulo = titulo;
        this.autor = autor;
        this.generoLiterario = generoLiterario;
        this.disponivel = true;
        this.dataCadastro = LocalDate.now();
    }

    public String toString(){
        return String.format("Livro: %s \nAutor: %s \nGenero Literário: %s \nData cadastro: %s ", titulo, autor.getNome(), generoLiterario.getNomeGeneroLiterario(), FormatadorData.formatarData(dataCadastro));
    }


}

