package com.sistema.biblioteca.entity.pessoa.cliente;

public class UsuarioInexistenteException extends RuntimeException{
    public UsuarioInexistenteException(){
        super ("Esse usuário não existe");
    }
}
