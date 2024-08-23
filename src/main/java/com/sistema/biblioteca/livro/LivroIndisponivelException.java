package com.sistema.biblioteca.livro;

public class LivroIndisponivelException extends Exception{
    public LivroIndisponivelException (){
        super ("Livro indisponível");
    }
}
