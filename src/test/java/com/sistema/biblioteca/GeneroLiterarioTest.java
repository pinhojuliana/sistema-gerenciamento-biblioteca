package com.sistema.biblioteca;

import com.sistema.biblioteca.livro.GeneroLiterario;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class GeneroLiterarioTest {

    @Test
    void deveRetornarGenero(){
        assertEquals("Romance", Objects.requireNonNull(GeneroLiterario.verificarExistenciaGenero("Romance")).getNomeGeneroLiterario());
    }

    @Test
    void deveRetornarNulo(){
        assertNull(GeneroLiterario.verificarExistenciaGenero("Mangá"));
    }

}
