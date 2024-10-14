package com.sistema.biblioteca.application;

import com.sistema.biblioteca.autor.Autor;
import com.sistema.biblioteca.autor.AutorService;
import com.sistema.biblioteca.biblioteca.Biblioteca;
import com.sistema.biblioteca.cliente.Cliente;
import com.sistema.biblioteca.cliente.ClienteService;
import com.sistema.biblioteca.cliente.UsuarioInexistenteException;
import com.sistema.biblioteca.emprestimo.EmprestimoService;
import com.sistema.biblioteca.livro.LivroIndisponivelException;
import com.sistema.biblioteca.livro.GeneroLiterario;
import com.sistema.biblioteca.livro.Livro;
import com.sistema.biblioteca.livro.LivroService;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/* Modificar opções para ter uma opção de pegar livro ou não dentro da opção 1
* Verificar se os métodos estao com seus respectivos metodos de validação
* Criar testes unitários*/

public class SistemaBiblioteca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ClienteService clienteService = new ClienteService();
        AutorService autorService = new AutorService();
        EmprestimoService emprestimoService = new EmprestimoService();
        LivroService livroService = new LivroService();

        Biblioteca biblioteca = new Biblioteca(autorService, livroService, emprestimoService, clienteService);

        livroService.cadastrarLivro("1984", new Autor("George Orwell"), GeneroLiterario.FICCAO_CIENTIFICA);
        livroService.cadastrarLivro("Assassinato no Expresso do Oriente", new Autor("Agatha Cristhie"), GeneroLiterario.ROMANCE_POLICIAL);
        livroService.cadastrarLivro("O Pequeno Principe", new Autor("Antoine de Saint-Exupéry"), GeneroLiterario.FANTASIA);
        livroService.cadastrarLivro("Verdadeiro Evangelho", new Autor("Paul Washer"), GeneroLiterario.RELIGIOSO);
        livroService.cadastrarLivro("Trabalho Focado", new Autor("Carl Newport"), GeneroLiterario.DESENVOLVIMENTO_PESSOAL);
        livroService.cadastrarLivro("Iracema", new Autor("José de Alencar"), GeneroLiterario.ROMANCE);

        System.out.println("--- Bem-vindo ao sistema de Biblioteca ---");
        while(true){
            System.out.println("Escolha uma opção para continuar:\n1- Ver os livros disponíveis para empréstimo\n2- Cadastrar usuário\n3- Cadastrar novo livro\n4- Pesquisar livro\n5- Verificar empréstimos de um usuário\n6- Verificar empréstimos de um livro\n7- Sair "));

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
                    Cliente cliente = clienteService.verificarCliente(usuarioCliente);
                                try {
                                    Livro livro = livroService.pesquisarLivroTitulo(tituloLivroEmprestimo);
                                    emprestimoService.emprestarLivro(cliente, livro);
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

                LocalDate dataFormatada;
                while (true) {
                    try {
                        System.out.println("Insira sua data de nascimeno (dd/MM/yyyy):");
                        String dataNascimento = scanner.nextLine();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        dataFormatada = LocalDate.parse(dataNascimento, formatter);
                        break;
                    } catch (DateTimeException e) {
                        System.out.println("Data inválida");
                    }
                }

                System.out.println("Insira um e-mail valido:");
                String email = scanner.nextLine();

                String nomeUsuario;
                while (true){
                    System.out.println("Escolha um nome de usuário:");
                    nomeUsuario = scanner.nextLine();
                    try {
                        clienteService.verificarCliente(nomeUsuario);
                        System.out.println("Nome indisponível. Escolha outro nome de usuário.");
                    } catch (UsuarioInexistenteException e) {
                        break;
                    }
                }
                clienteService.cadastrarCliente(nome, nomeUsuario, dataFormatada, email);
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
                        livroService.verificarCadastroLivro(titulo, autorService.verificarAutor());
                        Autor autor = autorService.verificarAutor(nomeAutor);
                            if(autorService.verificarAutor(nomeAutor) == null){
                                livroService.cadastrarLivro(titulo, new Autor(nomeAutor, dataNascimento), generoSelecionado);
                            } else {
                                livroService.cadastrarLivro(titulo, autor, generoSelecionado);
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
                        System.out.println(livroService.pesquisarLivroTitulo(titulo));
                    } catch (LivroIndisponivelException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (input == 2){
                    System.out.println("Gẽneros literários disponíveis:\n " + GeneroLiterario.mostrarOpcoesGeneroLiterario());
                    System.out.println("Livros de qual gênero literário deseja pesquisar?");
                    String generoLiterario = scanner.nextLine();
                    System.out.println(livroService.pesquisarLivroGenero(GeneroLiterario.verificarExistenciaGenero(generoLiterario)));
                }
            }

            if(opcao == 5){
                System.out.println("Qual o nome de usuário do cliente que deseja verificar?");
                String nomeUsuario = scanner.nextLine();
                try {
                    System.out.println(clienteService.verificarCliente(nomeUsuario).mostrarEmprestimosCliente());
                }
                catch (UsuarioInexistenteException e){
                    System.out.println(e.getMessage());
                }
            }

            if(opcao == 6){
                try{
                    System.out.println("Para pesquisar os empŕestimos de um livro insira seu título: ");
                    String tituloLivro = scanner.nextLine();
                    System.out.println(emprestimoService.mostrarEmprestimosLivro(livroService.pesquisarLivroTitulo(tituloLivro)));
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
