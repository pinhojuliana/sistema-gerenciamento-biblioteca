package com.sistema.biblioteca.cliente;

public class UsuarioInexistensException extends RuntimeException{
    public UsuarioInexistensException (){
        super ("Esse usuário não existe");
    }
}
