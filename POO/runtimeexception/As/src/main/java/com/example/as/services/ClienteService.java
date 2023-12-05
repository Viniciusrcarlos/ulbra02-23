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

    //adiciona um cliente
    public Cliente addClient(Cliente cliente) {
        repository.save(cliente);
        return cliente;
    }

    //atualiza o cliente com o ID fornecido
    public String updateClient(long id, Cliente updatedCliente) {
        Cliente atualizar = repository.findById(id).orElse(null);
        BeanUtils.copyProperties(updatedCliente, atualizar, "id");
        repository.save(atualizar);
        return "Atualizado com sucesso!!";
    }

    //deleta o cliente com o id fornecido
    public String deleteClient(long id) {
        Cliente cliente = repository.findById(id).orElse(null);
        repository.delete(cliente);

        return "Cliente removido";
    }

    // retorna o cliente pelo id fornecido
    public Cliente getClienteById(long id) {
        return repository.findById(id).orElse(null);
    }

    //retorna um cliente com a idade fornecida
    public List<Cliente> getClientsByIdade(int idade) {
        List<Cliente> lista = repository.findByIdade(idade);

        return lista;
    }





}
