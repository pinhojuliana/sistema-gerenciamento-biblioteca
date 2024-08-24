package com.sistema.biblioteca.cliente;

public class UsuarioInexistenteException extends RuntimeException{
    public UsuarioInexistenteException(){
        super ("Esse usuário não existe");
    }
}
