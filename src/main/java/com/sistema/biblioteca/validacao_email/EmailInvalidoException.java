package com.sistema.biblioteca.validacao_email;

public class EmailInvalidoException extends Exception{
    public EmailInvalidoException(String message) {
        super(message);
    }
}
