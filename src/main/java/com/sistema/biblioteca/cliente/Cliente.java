package com.sistema.biblioteca.cliente;

import com.sistema.biblioteca.classes_pai.Pessoa;
import com.sistema.biblioteca.emprestimo.Emprestimo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.*;

@Getter
@Setter
public class Cliente extends Pessoa {
    private String nomeUsuario;
    private String email;
    private List<Emprestimo> emprestimos;

    public Cliente(String nome, String nomeUsuario, LocalDate dataNascimento, String email) {
        super(nome, dataNascimento);
        this.nomeUsuario = nomeUsuario;
        //criar validação de email
        this.email = email;
        this.emprestimos = new ArrayList<>();
    }

    public String toString(){
        return String.format("Cliente: %s \nNome: %s \nId: %s", nomeUsuario, super.getNome(), super.getId().toString());
    }

}
