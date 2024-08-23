package com.sistema.biblioteca.livro;

import com.sistema.biblioteca.autor.Autor;
import com.sistema.biblioteca.biblioteca.FormatadorData;
import com.sistema.biblioteca.cliente.Cliente;
import com.sistema.biblioteca.emprestimo.Emprestimo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
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
    private Map<Cliente, LocalDate> emprestimosLivro = new HashMap<>();


    public Livro(String titulo, Autor autor){
        this.id = UUID.randomUUID();
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
        this.dataCadastro = LocalDate.now();
    }

    public Livro(String titulo, Autor autor, GeneroLiterario generoLiterario){
        this.id = UUID.randomUUID();
        this.titulo = titulo;
        this.autor = autor;
        this.generoLiterario = generoLiterario;
        this.disponivel = true;
        this.dataCadastro = LocalDate.now();
    }

    public String toString(){
        return String.format("Livro: %s \nAutor: %s \nGenero Literário: %s \nData cadastro: %s ", titulo, autor.getNome(), generoLiterario.getNomeGeneroLiterario(), new FormatadorData(dataCadastro).formatarData());
    }

    public String mostrarEmprestimosLivro(){
        StringBuilder resultado = new StringBuilder();
        for (Map.Entry<Cliente, LocalDate> entry : emprestimosLivro.entrySet()) {
            resultado.append(entry.getKey().getNomeUsuario()).append(" - ").append(entry.getValue()).append("\n");
        }
        return resultado.toString();
    }

}

