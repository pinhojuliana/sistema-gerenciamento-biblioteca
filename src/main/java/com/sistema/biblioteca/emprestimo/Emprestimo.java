package com.sistema.biblioteca.emprestimo;

import com.sistema.biblioteca.biblioteca.FormatadorData;
import com.sistema.biblioteca.cliente.Cliente;
import com.sistema.biblioteca.livro.Livro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Emprestimo {
    private Livro livro;
    private Cliente cliente;
    private LocalDate dataEmprestimo;

    public Emprestimo(Livro livro, Cliente cliente){
        this.livro = livro;
        this.cliente = cliente;
        this.dataEmprestimo = LocalDate.now();
    }

    public String toString(){
        return String.format("Livro: %s \nCliente que realizou o empréstimo: %s \nData do empréstimo: %s",
                livro.getTitulo(), cliente.getNome(), new FormatadorData(dataEmprestimo).formatarData());
    }

}
