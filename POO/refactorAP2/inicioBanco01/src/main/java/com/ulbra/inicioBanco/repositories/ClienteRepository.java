package com.ulbra.inicioBanco.repositories;

import com.ulbra.inicioBanco.entities.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
