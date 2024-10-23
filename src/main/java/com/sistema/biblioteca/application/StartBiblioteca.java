package com.sistema.biblioteca.application;

import com.sistema.biblioteca.entity.pessoa.autor.AutorService;
import com.sistema.biblioteca.entity.biblioteca.MenuBiblioteca;
import com.sistema.biblioteca.entity.pessoa.cliente.ClienteService;
import com.sistema.biblioteca.entity.emprestimo.EmprestimoService;
import com.sistema.biblioteca.entity.livro.LivroService;
import org.springframework.boot.CommandLineRunner;

import java.util.InputMismatchException;
import java.util.Scanner;

//@Component
public class StartBiblioteca implements CommandLineRunner{
    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        ClienteService clienteService = new ClienteService();
        AutorService autorService = new AutorService();
        EmprestimoService emprestimoService = new EmprestimoService();
        LivroService livroService = new LivroService();

        MenuBiblioteca menuBiblioteca = new MenuBiblioteca(scanner, clienteService, livroService, emprestimoService, autorService);

        livroService.cadastrarLivrosPadrao();

        System.out.println("--- Bem-vindo ao sistema de Biblioteca ---");

        while(true){
            menuBiblioteca.mostrarMenuPrincipal();

            int opcao = obterOpcaoMenu(scanner);

            if(opcao == 7)
                break;

            menuBiblioteca.executarAcaoMenu(opcao);
        }
        scanner.close();
        System.out.println("Programa encerrado.");
    }

    private static int obterOpcaoMenu(Scanner scanner) {
        int opcao = 0;
        try {
            opcao = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida! Por favor, insira um número.");
        } finally {
            scanner.nextLine();
        }
        return opcao;
    }
}


