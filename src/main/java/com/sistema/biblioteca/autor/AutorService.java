package com.sistema.biblioteca.autor;

import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
public class AutorService {
    private List<Autor> autores;

    public AutorService(){
        this.autores = new ArrayList<>();
    }

    public void cadastrarAutor(String nome, LocalDate dataNascimento){

    }

    public Autor verificarAutor(String nomeAutor){
        for(Autor autor : autores){
            if(nomeAutor.equalsIgnoreCase(autor.getNome())){
                return autor;
            }
        }
        return null;
    }
}
