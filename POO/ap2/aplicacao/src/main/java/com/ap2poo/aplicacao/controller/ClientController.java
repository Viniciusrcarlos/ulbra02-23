package com.ap2poo.aplicacao.controller;

import com.ap2poo.aplicacao.model.Cliente;
import com.ap2poo.aplicacao.services.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/cliente")
public class ClientController {
    private final ClientService clientService;

    // O construtor recebe uma instância de ClientService injetada pelo Spring
    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    // Este método vai tratar as requisições GET para "/clients" e retornará uma lista de todos os clientes.
    @GetMapping
    public List<Cliente> getAllClients() {
        return clientService.getAllClients();
    }

    // Este método vai tratar as requisições GET para "/clients/{id}" e retornará um cliente com um ID específico.
    @GetMapping("/{id}")
    public ArrayList<Cliente> getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    // Método que vai tratar as requisições GET para "/clients" com o parâmetro "age" e retornará uma lista de clientes com a idade especificada.
    @GetMapping(params = "idade")
    public List<Cliente> getClientsByAge(@RequestParam int idade) {
        return clientService.getClientsByAge(idade);
    }

    // Método que vai tratar as requisições POST para "/clients" e adicionará um novo cliente.
    @PostMapping
    public Cliente addClient(@RequestBody Cliente cliente) {
        return clientService.addClient(cliente);
    }

    // Método que vai tratar as requisições PUT para "/clients/{id}" e atualizará um cliente com o ID especificado com os dados fornecidos.
    @PutMapping("/{id}")
    public Cliente updateClient(@PathVariable Long id, @RequestBody Cliente updatedCliente) {
        return clientService.updateClient(id, updatedCliente);
    }

    // Método que vai tratar as requisições DELETE para "/clients/{id}" e excluirá o cliente com o ID especificado.
    @DeleteMapping("/{id}")
    public boolean deleteClient(@PathVariable Long id) {
        return clientService.deleteClient(id);
    }
}