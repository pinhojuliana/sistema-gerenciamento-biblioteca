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

    public void cadastrarLivro(String titulo, Autor autor, GeneroLiterario generoLiterario){
        Livro livro = new Livro(titulo, autor, generoLiterario);
        livro.setDataAtualizacao(LocalDate.now());
        livros.add(livro);
    }

    public void mostrarLivrosDisponiveis(){
        List<Livro> livrosDisponiveis = new ArrayList<>();
        for(Livro livro : livros){
            if(livro.isDisponivel()){
                livrosDisponiveis.add(livro);
            }
        }
        for(Livro livro : livrosDisponiveis){
            System.out.println(livro.getTitulo());
        }
    }

    public void emprestarLivro(Cliente cliente, Livro livro) throws LivroIndisponivelException {
            if (livro.isDisponivel()) {
                livro.setDisponivel(false);
                livro.setDataAtualizacao(LocalDate.now());

                Emprestimo emprestimo = new Emprestimo(livro, cliente);
                emprestimos.add(emprestimo);

                livro.getEmprestimosLivro().put(cliente, LocalDate.now());

                cliente.getLivrosEmprestados().put(livro, LocalDate.now());
            } else {
                throw new LivroIndisponivelException();
            }
    }

    public void verificarCadastroLivro(String titulo, String nomeAutor) {
        for (Livro livro : livros) {
            if (titulo.equalsIgnoreCase(livro.getTitulo()) || nomeAutor.equalsIgnoreCase(livro.getAutor().getNome())) {
                throw new RuntimeException("Não é possível cadastrar este livro.Livro já cadastrado.");
            }
        }
    }

    public Livro pesquisarLivroTitulo(String tituloLivro) throws LivroIndisponivelException{
        for (Livro livro : livros){
            if(tituloLivro.equalsIgnoreCase(livro.getTitulo())){
                return livro;
            }
        }
        throw new LivroIndisponivelException();
    }

    public String pesquisarLivroGenero(GeneroLiterario generoLiterario){
        List<Livro> livrosGeneroPesquisado = new ArrayList<>();
        StringBuilder livrosGeneroString = new StringBuilder();
        for(Livro livro : livros){
            if(livro.getGeneroLiterario() == generoLiterario){
                livrosGeneroPesquisado.add(livro);
            }
        }
        for (Livro livro :livrosGeneroPesquisado){
            livrosGeneroString.append(livro.getTitulo()).append("\n");
        }
        return livrosGeneroString.toString();
    }

    public Cliente cadastrarCliente(String nome, String nomeUsuario, LocalDate dataNascimento, String email){
        Cliente cliente = new Cliente(nome, nomeUsuario, dataNascimento, email);
        clientes.add(cliente);
        return cliente;
    }

    public String mostrarClientesCadastrados(){
        StringBuilder clientesCadastrados = new StringBuilder();
        for (Cliente cliente : clientes) {
            clientesCadastrados.append(cliente.getNomeUsuario()).append("\n");
        }
        return clientesCadastrados.toString();
    }

    public Cliente verificarCliente(String nomeUsuario) throws UsuarioInexistenteException {
        for (Cliente cliente : clientes) {
            if (nomeUsuario.equalsIgnoreCase(cliente.getNomeUsuario())) {
                return cliente;
            }
        }
        throw new UsuarioInexistenteException();
    }

    public Autor verificarAutor(String nomeAutor){
        for(Autor autor : autores){
            if(nomeAutor.equalsIgnoreCase(autor.getNome())){
                return autor;
            }
        }
        return null;
    }


}
