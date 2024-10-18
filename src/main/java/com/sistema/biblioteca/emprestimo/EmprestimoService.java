package com.sistema.biblioteca.emprestimo;

import com.sistema.biblioteca.cliente.Cliente;
import com.sistema.biblioteca.livro.Livro;
import com.sistema.biblioteca.livro.LivroIndisponivelException;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class EmprestimoService {
    private List<Emprestimo> emprestimos;

    public EmprestimoService() {
        this.emprestimos = new ArrayList<>();
    }

    public void emprestarLivro(Cliente cliente, Livro livro) throws LivroIndisponivelException {
        if (livro.isDisponivel()) {
            livro.setDisponivel(false);
            livro.setDataAtualizacao(LocalDate.now());

            Emprestimo emprestimo = new Emprestimo(livro, cliente);
            emprestimos.add(emprestimo);

            livro.getEmprestimosLivro().add(emprestimo);

            cliente.getEmprestimos().add(emprestimo);
        } else {
            throw new LivroIndisponivelException();
        }
    }

    public String mostrarEmprestimosCliente(Cliente cliente){
        if(cliente.getEmprestimos().isEmpty()){
            return "Nenhuma atividade registrada";
        } else {
            return cliente.getEmprestimos().stream()
                    .sorted(Comparator.comparing(Emprestimo::getDataEmprestimo))
                    .map(e -> "Livro: " + e.getLivro().getTitulo() + ", Data: " + e.getDataEmprestimo())
                    .collect(Collectors.joining("\n"));
        }
    }

    public String mostrarEmprestimosLivro(Livro livro) {
        if(livro.getEmprestimosLivro().isEmpty()){
            return "Nenhuma atividade registrada";
        }
        return livro.getEmprestimosLivro().stream()
                .sorted(Comparator.comparing(Emprestimo::getDataEmprestimo))
                .map(e -> "Cliente: " + e.getCliente().getNomeUsuario() + ", Data: " + e.getDataEmprestimo())
                .collect(Collectors.joining("\n"));
    }
}
