package com.sistema.biblioteca.entity.livro;

public class LivroIndisponivelException extends RuntimeException{
    public LivroIndisponivelException (){
        super ("Livro indisponível");
    }
}
