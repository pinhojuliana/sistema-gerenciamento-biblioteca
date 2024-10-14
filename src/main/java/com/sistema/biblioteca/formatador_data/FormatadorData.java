package com.sistema.biblioteca.formatador_data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormatadorData {
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/mm/yyyy");

    public static String formatarData(LocalDate data){
        return FORMATTER.format(data);
    }

    public static LocalDate formatarString(String data){
        return LocalDate.parse(data, FORMATTER);
    }
}
