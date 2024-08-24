package com.sistema.biblioteca.biblioteca;

import com.sistema.biblioteca.autor.Autor;
import com.sistema.biblioteca.cliente.Cliente;
import com.sistema.biblioteca.cliente.UsuarioInexistenteException;
import com.sistema.biblioteca.livro.LivroIndisponivelException;
import com.sistema.biblioteca.livro.GeneroLiterario;
import com.sistema.biblioteca.livro.Livro;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SistemaBiblioteca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Biblioteca biblioteca = new Biblioteca();

        biblioteca.cadastrarLivro("1984", new Autor("George Orwell"), GeneroLiterario.FICCAO_CIENTIFICA);
        biblioteca.cadastrarLivro("Assassinato no Expresso do Oriente", new Autor("Agatha Cristhie"), GeneroLiterario.ROMANCE_POLICIAL);
        biblioteca.cadastrarLivro("O Pequeno Principe", new Autor("Antoine de Saint-Exupéry"), GeneroLiterario.FANTASIA);
        biblioteca.cadastrarLivro("Verdadeiro Evangelho", new Autor("Paul Washer"), GeneroLiterario.RELIGIOSO);
        biblioteca.cadastrarLivro("Trabalho Focado", new Autor("Carl Newport"), GeneroLiterario.DESENVOLVIMENTO_PESSOAL);
        biblioteca.cadastrarLivro("Iracema", new Autor("José de Alencar"), GeneroLiterario.ROMANCE);

        System.out.println("--- Bem-vindo ao sistema de Biblioteca ---");
        while(true){
            System.out.println("Escolha uma opção para continuar:");
            System.out.println("1- Ver os livros disponíveis para empréstimo");
            System.out.println("2- Cadastrar usuário");
            System.out.println("3- Cadastrar novo livro");
            System.out.println("4- Pesquisar livro");
            System.out.println("5- Verificar empréstimos de um usuário");
            System.out.println("6- Verificar empréstimos de um livro");
            System.out.println("7- Sair ");

            int opcao = scanner.nextInt();
            if(opcao == 7)
                break;

            scanner.nextLine();

            if(opcao == 1) {
                System.out.println("Livros disponíveis:");
                biblioteca.mostrarLivrosDisponiveis();

                System.out.println("Qual livro deseja pegar emprestado?");
                String tituloLivroEmprestimo = scanner.nextLine();

                try {
                    System.out.println("Qual é o seu nome de usuário?");
                    String usuarioCliente = scanner.nextLine();
                    Cliente cliente = biblioteca.verificarCliente(usuarioCliente);
                                try {
                                    Livro livro = biblioteca.pesquisarLivroTitulo(tituloLivroEmprestimo);
                                    biblioteca.emprestarLivro(cliente, livro);
                                    System.out.println("Livro: " + livro.getTitulo() + ", id: " + livro.getId() + " foi emprestado para o cliente: " + usuarioCliente);
                                } catch (LivroIndisponivelException n) {
                                    System.out.println(n.getMessage());
                                }

                }catch (UsuarioInexistenteException e){
                    System.out.println(e.getMessage());
                }
            }

            if(opcao == 2){
                System.out.println("Para cadastrar um novo usuário, nosso sitema precisa de algumas informacoes...");

                System.out.println("Insira seu nome completo:");
                String nome = scanner.nextLine();

                System.out.println("Insira sua data de nascimeno (dd/MM/yyyy):");
                String dataNascimento = scanner.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate dataFormatada = LocalDate.parse(dataNascimento, formatter);

                System.out.println("Insira um e-mail valido:");
                String email = scanner.nextLine();

                String nomeUsuario;
                while (true){
                    System.out.println("Escolha um nome de usuário:");
                    nomeUsuario = scanner.nextLine();
                    try {
                        biblioteca.verificarCliente(nomeUsuario);
                        System.out.println("Nome indisponível. Escolha outro nome de usuário.");
                    } catch (UsuarioInexistenteException e) {
                        break;
                    }
                }
                biblioteca.cadastrarCliente(nome, nomeUsuario, dataFormatada, email);
                System.out.println("Cliente cadastrado com sucesso! Guarde seu nome de usuário para futuras consultas e empréstimos de livros.");
            }

            if(opcao == 3){
                System.out.println("Qual o título do Livro?");
                String titulo = scanner.nextLine();
                System.out.println("Qual o nome do autor do livro?");
                String nomeAutor = scanner.nextLine();
                System.out.println("Qual o gênero literário desse livro?");
                GeneroLiterario generoSelecionado;
                while (true) {
                    String entrada = scanner.nextLine();
                    generoSelecionado = GeneroLiterario.verificarExistenciaGenero(entrada);

                    if (generoSelecionado == null) {
                        System.out.println("Gênero Literário inválido. Por favor, insira um válido: ");
                    } else {
                        break;
                    }
                }
                    try{
                        biblioteca.verificarCadastroLivro(titulo, nomeAutor);
                        Autor autor = biblioteca.verificarAutor(nomeAutor);
                            if(biblioteca.verificarAutor(nomeAutor) == null){
                                biblioteca.cadastrarLivro(titulo, new Autor(nomeAutor), generoSelecionado);
                            } else {
                                biblioteca.cadastrarLivro(titulo, autor, generoSelecionado);
                            }
                        System.out.println("Livro cadastrado com sucesso.");
                    }
                    catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
            }

            if(opcao == 4){
                System.out.println("Para pesquisar insira uma opção: ");
                System.out.println("1- Pesquisar por título");
                System.out.println("2- Pesquisar por gênero literário");
                int input = scanner.nextInt();
                scanner.nextLine();
                if (input == 1) {
                    try {
                        System.out.println("Por favo insira o título do livro: ");
                        String titulo = scanner.nextLine();
                        System.out.println(biblioteca.pesquisarLivroTitulo(titulo));
                    } catch (LivroIndisponivelException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (input == 2){
                    System.out.println("Gẽneros literários disponíveis:\n " + GeneroLiterario.mostrarOpcoesGeneroLiterario());
                    System.out.println("Livros de qual gênero literário deseja pesquisar?");
                    String generoLiterario = scanner.nextLine();
                    System.out.println(biblioteca.pesquisarLivroGenero(GeneroLiterario.verificarExistenciaGenero(generoLiterario)));
                }
            }

            if(opcao == 5){
                System.out.println("Qual o nome de usuário do cliente que deseja verificar?");
                String nomeUsuario = scanner.nextLine();
                try {
                    System.out.println(biblioteca.verificarCliente(nomeUsuario).mostrarEmprestimosCliente());
                }
                catch (UsuarioInexistenteException e){
                    System.out.println(e.getMessage());
                }
            }

            if(opcao == 6){
                try{
                    System.out.println("Para pesquisar os empŕestimos de um livro insira seu título: ");
                    String tituloLivro = scanner.nextLine();
                    System.out.println(biblioteca.pesquisarLivroTitulo(tituloLivro).mostrarEmprestimosLivro());
                } catch (LivroIndisponivelException e) {
                    System.out.println(e.getMessage());
                }
            }


            if (opcao < 1 || opcao > 7) {
                System.out.println("Opção inválida. Por favor, insira uma opção válida");
            }

        }
        scanner.close();
        System.out.println("Programa encerrado.");
    }
}
