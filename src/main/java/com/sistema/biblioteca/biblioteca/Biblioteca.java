package com.sistema.biblioteca.biblioteca;

import com.sistema.biblioteca.cliente.Cliente;
import com.sistema.biblioteca.cliente.UsuarioInexistenteException;
import com.sistema.biblioteca.emprestimo.Emprestimo;
import com.sistema.biblioteca.autor.Autor;
import com.sistema.biblioteca.livro.LivroIndisponivelException;
import com.sistema.biblioteca.livro.GeneroLiterario;
import com.sistema.biblioteca.livro.Livro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private List<Emprestimo> emprestimos =new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    public String exibirMenu(){
        return "Escolha uma opção para continuar:\n1- Ver os livros disponíveis para empréstimo\n2- Cadastrar usuário\n3- Cadastrar novo livro\n4- Pesquisar livro\n5- Verificar empréstimos de um usuário\n6- Verificar empréstimos de um livro\n7- Sair ";
    }

}
