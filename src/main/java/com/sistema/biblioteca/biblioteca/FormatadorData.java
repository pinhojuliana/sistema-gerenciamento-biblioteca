package com.sistema.biblioteca.biblioteca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public record FormatadorData(LocalDate data) {
    public String formatarData(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter);
    }
}
