package com.sistema.biblioteca.entity.pessoa.autor;

import com.sistema.biblioteca.entity.pessoa.Pessoa;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Autor extends Pessoa {
    public Autor(String nome, LocalDate dataNascimento){
       super(nome, dataNascimento);
    }

    public Autor(String nome){
        super(nome);
    }
}
