package com.sistema.biblioteca.validacao_email;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//@Component verificar
public class ValidacaoEmail {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    public static String validarEmail(String email) throws EmailInvalidoException {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches()) {
            return email;
        } else {
            throw new EmailInvalidoException("O e-mail" + email + " é inválido");
        }
    }

}
