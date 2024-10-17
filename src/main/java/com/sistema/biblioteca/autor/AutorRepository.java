package com.sistema.biblioteca.autor;

import com.sistema.biblioteca.livro.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AutorRepository extends JpaRepository<Livro, UUID> {
}
