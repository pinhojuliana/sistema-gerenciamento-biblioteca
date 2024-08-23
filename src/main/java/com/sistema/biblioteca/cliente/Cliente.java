package com.sistema.biblioteca.cliente;

import com.sistema.biblioteca.livro.Livro;
import lombok.AllArgsConstructor;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
public class Cliente {
    private UUID id;
    private String nome;
    private String nomeUsuario;
    private LocalDate dataNascimento;
    private String email;
    private Map<Livro, LocalDate> livrosEmprestados = new HashMap<>();

    public Cliente(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
        this.id = UUID.randomUUID();
    }

    public Cliente(String nome, String nomeUsuario, LocalDate dataNascimento, String email) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.nomeUsuario = nomeUsuario;
        this.dataNascimento = dataNascimento;
        this.email = email;
    }

    public String toString(){
        return String.format("Cliente: %s \nNome: %s \nId: %s", nomeUsuario, nome, id.toString());

    }

    public String mostrarEmprestimosCliente(){
        StringBuilder resultado = new StringBuilder();
        for (Map.Entry<Livro, LocalDate> entry : livrosEmprestados.entrySet()) {
            resultado.append(entry.getKey().getTitulo()).append(" - ").append(entry.getValue()).append("\n");
        }
        return resultado.toString();
    }


}
