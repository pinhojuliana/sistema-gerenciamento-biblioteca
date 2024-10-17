package com.sistema.biblioteca.emprestimo;

import com.sistema.biblioteca.livro.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmprestimoRespository extends JpaRepository<Livro, UUID> {
}
