package com.sistema.biblioteca.cliente;

import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ClienteService {
    private List<Cliente> clientes;

    public ClienteService(){
        this.clientes = new ArrayList<>();
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
}
