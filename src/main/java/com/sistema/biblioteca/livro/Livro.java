package com.sistema.biblioteca.livro;

import com.sistema.biblioteca.autor.Autor;
import com.sistema.biblioteca.emprestimo.Emprestimo;
import com.sistema.biblioteca.formatador_data.FormatadorData;
import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDate;
import java.util.*;

/*
* @Entity
* @Table (name = "livro")*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livro {
    //@Id
    //@Column
    private UUID id;
    //@Column
    private String titulo;
    //@Column
    private Autor autor;
    //@Column
    private boolean disponivel;
    //@Column
    private LocalDate dataCadastro;
    //@Column
    private LocalDate dataAtualizacao;
    //@Column
    private GeneroLiterario generoLiterario;
    //@Column
    private List<Emprestimo> emprestimosLivro;
    //@Column
    //private int quantidade;

    public Livro(String titulo, Autor autor, GeneroLiterario generoLiterario){
        this.id = UUID.randomUUID();
        this.titulo = titulo;
        this.autor = autor;
        this.generoLiterario = generoLiterario;
        this.disponivel = true;
        this.dataCadastro = LocalDate.now();
        this.emprestimosLivro = new ArrayList<>();
    }

    public String toString(){
        return String.format("Livro: %s\nAutor: %s\nGenero Literário: %s\nData cadastro: %s\nDisponível: %s ", titulo, autor.getNome(), generoLiterario.getNomeGeneroLiterario(), FormatadorData.formatarData(dataCadastro), isDisponivel());
    }


}

