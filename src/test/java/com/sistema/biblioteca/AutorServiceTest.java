package com.sistema.biblioteca;

import static org.junit.jupiter.api.Assertions.*;

import com.sistema.biblioteca.autor.Autor;
import com.sistema.biblioteca.autor.AutorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AutorServiceTest {
    @InjectMocks
    AutorService autorService;

    @Test
    void deveCadastrarAutor(){
        autorService.cadastrarAutor("George Orwell");
        assertEquals("George Orwell", autorService.getAutores().get(0).getNome());
    }

    @Test
    void deveRetornarAutor(){
        autorService.cadastrarAutor("George Orwell");
        assertEquals("George Orwell", autorService.getAutores().get(0).getNome());
    }

    @Test
    void deveLancarExcecao(){
        assertThrows(RuntimeException.class, ()-> {
            autorService.verificarAutor("George Orwell");
        });
    }
}
