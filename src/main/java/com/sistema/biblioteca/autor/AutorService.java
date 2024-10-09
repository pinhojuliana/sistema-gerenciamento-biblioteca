package com.sistema.biblioteca.autor;

import com.sistema.biblioteca.cliente.UsuarioInexistenteException;
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
        //verificar se existe, se sim lança exceção
    }

    public Autor verificarAutor(String nomeAutor){
        return autores.stream()
                .filter(c -> c.getNome().equalsIgnoreCase(nomeAutor))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Esse autor não existe no nosso sistema."));
    }
}
