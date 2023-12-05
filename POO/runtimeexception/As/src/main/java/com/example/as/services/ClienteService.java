package com.example.as.services;

import com.example.as.entities.Cliente;
import com.example.as.repositories.ClienteRepository;
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

    private ArrayList<Cliente> clientes = new ArrayList<>();
    private int proximoId = 1;

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
    public Cliente updateClient(int id, Cliente updatedCliente) {
        
    }

    public boolean deleteClient(int id) {
        return clientes.removeIf(cliente -> Objects.equals(cliente.getId(), id));
    }

    // Retorna um cliente por ID
    public Cliente getClienteById(long id) {
        return repository.findById(id);
    }

    //Retorna um cliente com uma idade específica
    public List<Cliente> getClientsByIdade(int idade) {
        List<Cliente> clienteByIdade = new ArrayList();
        for (Cliente cliente : clientes) {
            if (cliente.getIdade() == idade) {
                clienteByIdade.add(cliente);
            }
        }
        return clienteByIdade;
    }





}
