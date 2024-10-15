package com.sistema.biblioteca.application;

import com.sistema.biblioteca.autor.Autor;
import com.sistema.biblioteca.autor.AutorService;
import com.sistema.biblioteca.biblioteca.Biblioteca;
import com.sistema.biblioteca.biblioteca.MenuBiblioteca;
import com.sistema.biblioteca.cliente.ClienteService;
import com.sistema.biblioteca.emprestimo.EmprestimoService;
import com.sistema.biblioteca.livro.GeneroLiterario;
import com.sistema.biblioteca.livro.LivroService;

import java.util.Scanner;

/* Verificar se os métodos estao com seus respectivos metodos de validação
* Criar testes unitários
* verificar o continue/return na classe de menu*/

public class SistemaBiblioteca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ClienteService clienteService = new ClienteService();
        AutorService autorService = new AutorService();
        EmprestimoService emprestimoService = new EmprestimoService();
        LivroService livroService = new LivroService();

        MenuBiblioteca menuBiblioteca = new MenuBiblioteca(scanner, clienteService, livroService, emprestimoService, autorService);
        Biblioteca biblioteca = new Biblioteca(autorService, livroService, emprestimoService, clienteService);

        livroService.cadastrarLivro("1984", new Autor("George Orwell"), GeneroLiterario.FICCAO_CIENTIFICA);
        livroService.cadastrarLivro("Assassinato no Expresso do Oriente", new Autor("Agatha Cristhie"), GeneroLiterario.ROMANCE_POLICIAL);
        livroService.cadastrarLivro("O Pequeno Principe", new Autor("Antoine de Saint-Exupéry"), GeneroLiterario.FANTASIA);
        livroService.cadastrarLivro("Verdadeiro Evangelho", new Autor("Paul Washer"), GeneroLiterario.RELIGIOSO);
        livroService.cadastrarLivro("Trabalho Focado", new Autor("Carl Newport"), GeneroLiterario.DESENVOLVIMENTO_PESSOAL);
        livroService.cadastrarLivro("Iracema", new Autor("José de Alencar"), GeneroLiterario.ROMANCE);

        System.out.println("--- Bem-vindo ao sistema de Biblioteca ---");
        while(true){
            menuBiblioteca.mostrarMenuPrincipal();

            int opcao = scanner.nextInt();
            if(opcao == 7)
                break;

            if (opcao < 1 || opcao > 7) {
                System.out.println("Opção inválida. Por favor, insira uma opção válida");
            }
            scanner.nextLine();

            if(opcao == 1) {
                menuBiblioteca.mostrarLivrosisponiveis();
            }

            if(opcao == 2){
                menuBiblioteca.cadastrarUsuario();
            }

            if(opcao == 3){
                menuBiblioteca.cadastrarNovoLivro();
            }

            if(opcao == 4){
                menuBiblioteca.pesquisarLivro();
            }

            if(opcao == 5){
                menuBiblioteca.mostrarEmprestimosCliente();
            }

            if(opcao == 6){
                menuBiblioteca.mostrarEmprestimosLivro();
            }

        }
        scanner.close();
        System.out.println("Programa encerrado.");
    }
}
