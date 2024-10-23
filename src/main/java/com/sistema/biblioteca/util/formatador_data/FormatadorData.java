package com.sistema.biblioteca.util.formatador_data;

import org.springframework.stereotype.Component;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//@Component verificar
public class FormatadorData {
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static String formatarData(LocalDate data) throws DateTimeException {
        return FORMATTER.format(data);
    }

    public static LocalDate formatarString(String data) throws DateTimeException{
        return LocalDate.parse(data, FORMATTER);
    }
}
