package com.sistema.biblioteca.emprestimo;

import com.sistema.biblioteca.cliente.Cliente;
import com.sistema.biblioteca.formatador_data.FormatadorData;
import com.sistema.biblioteca.livro.Livro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

/*
* @Entity
* @Table(name = "emprestimo")*/
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Emprestimo {
    //@Id
    //@Column
    //private UUID id;
    private Livro livro;
    //@Column
    private Cliente cliente;
    //@Column
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
