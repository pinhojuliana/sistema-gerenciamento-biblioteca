package com.sistema.biblioteca.cliente;

import com.sistema.biblioteca.classes_pai.Pessoa;
import com.sistema.biblioteca.emprestimo.Emprestimo;
import com.sistema.biblioteca.validacao_email.EmailInvalidoException;
import com.sistema.biblioteca.validacao_email.ValidacaoEmail;
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

    public Cliente(String nome, String nomeUsuario, LocalDate dataNascimento, String email) throws EmailInvalidoException{
        super(nome, dataNascimento);
        this.nomeUsuario = nomeUsuario;
        this.email = ValidacaoEmail.validarEmail(email);
        this.emprestimos = new ArrayList<>();
    }

    public String toString(){
        return String.format("Cliente: %s \nNome: %s \nId: %s", nomeUsuario, super.getNome(), super.getId().toString());
    }

}
