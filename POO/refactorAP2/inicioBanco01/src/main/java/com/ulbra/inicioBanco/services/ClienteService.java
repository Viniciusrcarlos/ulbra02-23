package com.ulbra.inicioBanco.services;


import com.ulbra.inicioBanco.dtos.ClienteDTO;
import com.ulbra.inicioBanco.entities.Cliente;
import com.ulbra.inicioBanco.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    ClienteRepository repository;

    @Autowired
    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }


    public ClienteDTO createCliente(ClienteDTO cliente) {
        Cliente clienteDtoToCliente = new Cliente(cliente.getName(), cliente.getIdade(), cliente.getProfissao());
        Cliente resultadoSave = this.repository.save(clienteDtoToCliente);
        return new ClienteDTO(resultadoSave.getName(), resultadoSave.getIdade(), resultadoSave.getProfissao());
    }
}
