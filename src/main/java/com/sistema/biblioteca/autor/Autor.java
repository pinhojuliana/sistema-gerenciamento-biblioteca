package com.sistema.biblioteca.autor;

import com.sistema.biblioteca.classes_pai.Pessoa;
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
