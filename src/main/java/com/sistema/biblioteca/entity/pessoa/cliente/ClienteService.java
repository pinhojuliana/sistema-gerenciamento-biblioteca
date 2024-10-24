package com.sistema.biblioteca.entity.pessoa.cliente;

import com.sistema.biblioteca.util.validacao_email.EmailInvalidoException;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ClienteService {
    private List<Cliente> clientes;


    public ClienteService(){
        this.clientes = new ArrayList<>();
    }

    public void cadastrarCliente(String nome, String nomeUsuario, LocalDate dataNascimento, String email) throws EmailInvalidoException {
        Cliente cliente = new Cliente(nome, nomeUsuario, dataNascimento, email);
        clientes.add(cliente);
        //verificar se o cliente existe com anyMatch do stram API
    }

    public String mostrarClientesCadastrados(){
        return clientes.stream().map(Cliente::getNomeUsuario)
                .collect(Collectors.joining("\n"));
    }

    public Cliente verificarCliente(String nomeUsuario) throws UsuarioInexistenteException {
        return clientes.stream()
                .filter(c -> c.getNomeUsuario().equalsIgnoreCase(nomeUsuario))
                .findFirst()
                .orElseThrow(UsuarioInexistenteException::new);
    }
}
