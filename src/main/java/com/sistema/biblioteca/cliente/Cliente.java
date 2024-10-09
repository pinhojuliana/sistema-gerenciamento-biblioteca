package com.sistema.biblioteca.cliente;

import com.sistema.biblioteca.Pessoa;
import com.sistema.biblioteca.emprestimo.Emprestimo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
public class Cliente extends Pessoa {
    private String nomeUsuario;
    private String email;
    private List<Emprestimo> emprestimos;

    public Cliente(String nome, String nomeUsuario, LocalDate dataNascimento, String email) {
        super(nome, dataNascimento);
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.emprestimos = new ArrayList<>();
    }

    public String toString(){
        return String.format("Cliente: %s \nNome: %s \nId: %s", nomeUsuario, super.getNome(), super.getId().toString());

    }

    public String mostrarEmprestimosCliente(){
        if(emprestimos.isEmpty()){
            return "Nenhuma atividade registrada";
        } else {
            return emprestimos.stream()
                    .sorted(Comparator.comparing(Emprestimo::getDataEmprestimo))
                    .map(e -> "Livro: " + e.getLivro().getTitulo() + ", Data: " + e.getDataEmprestimo())
                    .collect(Collectors.joining("\n"));
        }
    }


}
