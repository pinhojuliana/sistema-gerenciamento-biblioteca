package com.sistema.biblioteca.livro;

public class LivroIndisponivelException extends RuntimeException{
    public LivroIndisponivelException (){
        super ("Livro indisponível");
    }
}
