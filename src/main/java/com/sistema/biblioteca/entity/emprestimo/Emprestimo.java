package com.sistema.biblioteca.entity.emprestimo;

import com.sistema.biblioteca.entity.pessoa.cliente.Cliente;
import com.sistema.biblioteca.util.formatador_data.FormatadorData;
import com.sistema.biblioteca.entity.livro.Livro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
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
                livro.getTitulo(), cliente.getNome(), FormatadorData.formatarData(dataEmprestimo));
    }

}
