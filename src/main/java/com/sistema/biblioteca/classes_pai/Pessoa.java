package com.sistema.biblioteca.classes_pai;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

//@NoArgsConstructor
@Getter
public class Pessoa {
    //@Id
    //@Column
    private UUID id;
    //@Column
    private String nome;
    //@Column
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
