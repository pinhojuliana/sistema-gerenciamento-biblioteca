package com.sistema.biblioteca.entity.livro;

import com.sistema.biblioteca.entity.pessoa.autor.Autor;
import com.sistema.biblioteca.entity.emprestimo.Emprestimo;
import com.sistema.biblioteca.util.formatador_data.FormatadorData;
import lombok.*;

import java.time.LocalDate;
import java.util.*;

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

