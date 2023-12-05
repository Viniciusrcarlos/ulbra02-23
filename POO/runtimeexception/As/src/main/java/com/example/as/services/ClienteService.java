package com.example.as.services;

import com.example.as.entities.Cliente;
import com.example.as.repositories.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ClienteService {

    private ClienteRepository repository;

    @Autowired
    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }



    //retorna uma lista com todos os clientes
    public List<Cliente> getAllClients() {
        return repository.findAll();
    }

    //Add um novo cliente a lista e add um ID unico a ele
    public Cliente addClient(Cliente cliente) {
        repository.save(cliente);
        return cliente;
    }

    //Atualiza um cliente com base no ID com os dados fornecidos
    public String updateClient(long id, Cliente updatedCliente) {
        Cliente atualizar = repository.findById(id).orElse(null);
        BeanUtils.copyProperties(updatedCliente, atualizar, "id");
        repository.save(atualizar);
        return "Atualizado com sucesso!!";
    }

    public String deleteClient(long id) {
        Cliente cliente = repository.findById(id).orElse(null);
        repository.delete(cliente);

        return "Cliente removido";
    }

    // Retorna um cliente por ID
    public Cliente getClienteById(long id) {
        return repository.findById(id).orElse(null);
    }

    //Retorna um cliente com uma idade específica
    public List<Cliente> getClientsByIdade(int idade) {
        List<Cliente> lista = repository.findByIdade(idade);

        return lista;
    }





}
