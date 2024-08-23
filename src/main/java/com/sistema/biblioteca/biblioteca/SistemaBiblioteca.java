package com.sistema.biblioteca.biblioteca;

import com.sistema.biblioteca.autor.Autor;
import com.sistema.biblioteca.cliente.Cliente;
import com.sistema.biblioteca.cliente.UsuarioInexistensException;
import com.sistema.biblioteca.livro.LivroIndisponivelException;
import com.sistema.biblioteca.livro.GeneroLiterario;
import com.sistema.biblioteca.livro.Livro;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SistemaBiblioteca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("--- Bem-vindo ao sistema de Biblioteca ---");
            System.out.println("Escolha uma opção para continuar:");
            System.out.println("1- Ver os livros disponíveis para empréstimo");
            System.out.println("2- Cadastrar usuário.");
            System.out.println("3- Cadastrar novo livro");
            System.out.println("4- Pesquisar livro");
            System.out.println("5- Verificar empréstimos de um usuário");
            System.out.println("6- verificar empréstimos de um livro");
            System.out.println("7- Sair ");

            int opcao = scanner.nextInt();
            if(opcao == 7)
                break;

            Biblioteca biblioteca = new Biblioteca();

            biblioteca.cadastrarLivro("1984", new Autor("George Orwell"), GeneroLiterario.FICCAO_CIENTIFICA);
            biblioteca.cadastrarLivro("Assassinado no Expresso do Oriente", new Autor("Agatha Cristhie"), GeneroLiterario.ROMANCE_POLICIAL);
            biblioteca.cadastrarLivro("O Pequeno Principe", new Autor("Antoine de Saint-Exupéry"), GeneroLiterario.FANTASIA);
            biblioteca.cadastrarLivro("Verdadeiro Evangelho", new Autor("Paul Washer"), GeneroLiterario.RELIGIOSO);
            biblioteca.cadastrarLivro("Trabalho Focado", new Autor("Carl Newport"), GeneroLiterario.DESENVOLVIMENTO_PESSOAL);
            biblioteca.cadastrarLivro("Iracema", new Autor("José de Alencar"), GeneroLiterario.ROMANCE);

            scanner.nextLine();

            //testar funcionamento e consertar porque mudei o verificarCliente
            if(opcao == 1) {
                System.out.println("Livros disponíveis:");
                biblioteca.mostrarLivrosDisponiveis();

                System.out.println("Qual livro deseja pegar emprestado?");
                String livroEmprestimo = scanner.nextLine();

                System.out.println("Qual é o seu nome de usuário?");
                String usuarioCliente = scanner.nextLine();
                if (biblioteca.verificarCliente(usuarioCliente) == true) {
                    for (Livro livro : biblioteca.getLivros()) {
                        if (livroEmprestimo.equalsIgnoreCase(livro.getTitulo())) {
                            try {
                                biblioteca.emprestarLivro(new Cliente(usuarioCliente));
                                System.out.println("Livro: " + livro.getTitulo() + ", id: " + livro.getId() + " foi emprestado para o cliente: " + usuarioCliente);
                            } catch (LivroIndisponivelException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                } else {
                    System.out.println("Usuário inexistente. Não é possivel pegar livros emprestados sem um cadastro.");
                }
            }
            // a verificação de nome de usuario não está funcionando e consertar verificarCliente
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
                    if (biblioteca.verificarCliente(nomeUsuario)){
                        System.out.println("Nome indisponível. Escolha outro nome de usuario.");
                    } else {
                        break;
                    }
                }
                biblioteca.cadastrarCliente(nome, nomeUsuario, dataFormatada, email);
                System.out.println("Cliente cadastrado com sucesso! Guarde seu nome de usuário para futuras consultas e empréstimos de livros.");
            }
            // testar
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
                for(Livro livros : biblioteca.getLivros()){
                    if(titulo.equalsIgnoreCase(livros.getTitulo()) || nomeAutor.equalsIgnoreCase(livros.getAutor().getNome())){
                        System.out.println("Livro já cadastrado. Não é possível adicionar esse livro");
                    } else {
                        for(Autor autor : biblioteca.getAutores()){
                            if(nomeAutor.equalsIgnoreCase(autor.getNome())){
                                biblioteca.cadastrarLivro(titulo, autor, generoSelecionado);
                            } else {
                                biblioteca.cadastrarLivro(titulo, new Autor(nomeAutor), generoSelecionado);
                            }
                        }
                        System.out.println("Livro cadastrado com sucesso.");

                    }
                }

            }
            //testar
            if(opcao == 4){
                try {
                    System.out.println("Para pesquisar um livro, por favo insira seu título: ");
                    String titulo = scanner.nextLine();
                    System.out.println(biblioteca.pesquisarLivro(titulo));
                } catch (LivroIndisponivelException e){
                    System.out.println(e.getMessage());
                }
            }
            //testar
            if(opcao == 5){
                System.out.println("Qual o nome de usuário do cliente que deseja verificar?");
                String nomeUsuario = scanner.nextLine();
                try {
                    System.out.println(biblioteca.verificarCliente(nomeUsuario).mostrarEmprestimosCliente());
                }
                catch (UsuarioInexistensException e){
                    System.out.println(e.getMessage());
                }
            }
            //testar
            if(opcao == 6){
                try{
                    System.out.println("Para pesquisar os empŕestimos de um livro insira seu título: ");
                    String tituloLivro = scanner.nextLine();
                    System.out.println(biblioteca.pesquisarLivro(tituloLivro).mostrarEmprestimosLivro());
                } catch (LivroIndisponivelException e) {
                    System.out.println(e.getMessage());
                }
            }

        }
        scanner.close();
        System.out.println("Programa encerrado.");
    }
}
