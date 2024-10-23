package com.sistema.biblioteca;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.time.LocalDate;

public class FormatadorDataTest {

    @Test
    void deveRetornarStringFormatada(){
        assertEquals("28/09/2005", formatarData(LocalDate.of(2005, 9, 28)));
    }

    @Test
    void deveRetornarExcecaoDataInvalida(){
        assertThrows(DateTimeException.class, () -> {
            formatarData(LocalDate.of(1, 1, 2007));
        });
    }

    @Test
    void deveRetornarData(){
        assertEquals(LocalDate.of(1960, 3, 3), formatarString("03/03/1960"));
    }

    @Test
    void deveRetornarExcecaoStringInvalida(){
        assertThrows(DateTimeException.class, () -> {
           formatarString("12-5-2012");
        });
    }
}
