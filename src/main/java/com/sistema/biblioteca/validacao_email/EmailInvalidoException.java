package com.sistema.biblioteca.validacao_email;

public class EmailInvalidoException extends RuntimeException{
    public EmailInvalidoException(String message) {
        super(message);
    }
}

