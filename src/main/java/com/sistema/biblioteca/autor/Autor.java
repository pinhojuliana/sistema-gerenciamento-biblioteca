package com.sistema.biblioteca.autor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Autor {
    private UUID id;
    private String nome;
    private LocalDate dataNascimento;

    public Autor(String nome){
        this.id = UUID.randomUUID();
        this.nome = nome;
    }

    public Autor(String nome, LocalDate dataNascimento){
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
}
