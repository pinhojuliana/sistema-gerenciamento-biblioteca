package com.sistema.biblioteca.biblioteca;

import com.sistema.biblioteca.autor.AutorService;
import com.sistema.biblioteca.cliente.ClienteService;
import com.sistema.biblioteca.emprestimo.EmprestimoService;
import com.sistema.biblioteca.livro.LivroService;
import lombok.*;

@Data
public class Biblioteca {
    private AutorService autor;
    private LivroService livro;
    private EmprestimoService emprestimo;
    private ClienteService cliente;

    public Biblioteca(AutorService autorService, LivroService livroService,EmprestimoService emprestimoService , ClienteService clienteService) {
        this.autor = autorService;
        this.livro = livroService;
        this.emprestimo = emprestimoService;
        this.cliente = clienteService;
    }

}
