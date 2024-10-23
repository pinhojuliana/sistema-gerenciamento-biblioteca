package com.sistema.biblioteca.entity.pessoa;

import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
public class Pessoa {
    private UUID id;
    private String nome;
    private LocalDate dataNascimento;

    public Pessoa(String nome, LocalDate dataNascimento) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        //criar formatador de data para receber uma string no formato dd/mm/yyyy e formata-la
        this.dataNascimento = dataNascimento;
    }

    public Pessoa(String nome) {
        this.id = UUID.randomUUID();
        this.nome = nome;
    }
}
