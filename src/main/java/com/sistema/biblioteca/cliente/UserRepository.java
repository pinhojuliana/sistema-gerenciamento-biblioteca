package com.sistema.biblioteca.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<Cliente, UUID> {
}
