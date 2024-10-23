package com.sistema.biblioteca;

import static org.junit.jupiter.api.Assertions.*;

import com.sistema.biblioteca.util.validacao_email.EmailInvalidoException;
import com.sistema.biblioteca.util.validacao_email.ValidacaoEmail;
import org.junit.jupiter.api.Test;

public class ValidacaoEmailTest {
    @Test
    void deveRetornarEmail(){
        assertEquals("jujup@gmail.com", ValidacaoEmail.validarEmail("jujup@gmail.com"));
    }

    @Test
    void deveLancarExcecaoEmailInvalido(){
        assertThrows(EmailInvalidoException.class, ()-> {
            ValidacaoEmail.validarEmail("email.invalido");
        });
    }
}
