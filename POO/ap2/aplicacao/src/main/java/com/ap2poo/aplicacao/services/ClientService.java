package com.ap2poo.aplicacao.services;

import com.ap2poo.aplicacao.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ClientService {
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private Long nextId = 1L;

    // Retorna uma lista de todos os clientes.
    public List<Cliente> getAllClients() {
        return clientes;
    }

    // Retorna um cliente por ID (ou deveria retornar, mas atualmente retorna a lista inteira).
    public ArrayList<Cliente> getClientById(Long id) {
        return clientes;
    }

    // Retorna uma lista de clientes com a idade especificada (atualmente retorna a lista inteira).
    public List<Cliente> getClientsByAge(int age) {
        return clientes;
    }

    // Adiciona um novo cliente à lista, atribuindo um ID único a ele.
    public Cliente addClient(Cliente cliente) {
        cliente.setId(nextId);
        nextId++;
        clientes.add(cliente);
        return cliente;
    }

    // Atualiza um cliente com um ID específico com os dados fornecidos.
    public Cliente updateClient(Long id, Cliente updatedCliente) {
        return cli
    }

    // Exclui um cliente com um ID específico da lista de clientes.
    public boolean deleteClient(Long id) {
        return clientes.removeIf(cliente -> cliente.getId().equals(id));
    }
}