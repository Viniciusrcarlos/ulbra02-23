package com.aula.aplicacao.services;

import com.aula.aplicacao.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ClienteService {

    private ArrayList<Cliente> clientes = new ArrayList<>();
    private int proximoId = 1;

    //retorna uma lista com todos os clientes
    public List<Cliente> getAllClients() {
        return clientes;
    }

    //Add um novo cliente a lista e add um ID unico a ele
    public Cliente addClient(Cliente cliente) {
        cliente.setId(proximoId);
        proximoId++;
        clientes.add(cliente);
        return cliente;
    }

    //Atualiza um cliente com base no ID com os dados fornecidos
    public Cliente updateClient(int id, Cliente updatedCliente) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            if (Objects.equals(cliente.getId(), id)) {
                updatedCliente.setId(id);
                clientes.set(i, updatedCliente);
                return updatedCliente;
            }
        }
        return null; // Retorna nulo
    }

    public boolean deleteClient(int id) {
        return clientes.removeIf(cliente -> Objects.equals(cliente.getId(), id));
    }

    // Retorna um cliente por ID
    public Cliente getClienteById(int id) {
        for (Cliente cliente : clientes) {
            if (Objects.equals(cliente.getId(), id)) {
                return cliente;
            }
        }
        return null;
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
