package com.aula.aplicacao.controller;

import com.aula.aplicacao.model.Cliente;
import com.aula.aplicacao.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private ClienteService clienteService;

    //construtor --
    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    //retorna uma lista com todos os clientes  --
    @GetMapping
    public List<Cliente> getAllClients() {
        return clienteService.getAllClients();
    }

    // Retorna um cliente com o id específico
    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable int id) {
        return clienteService.getClienteById(id);
    }

    // filtra pela idade
    @GetMapping(params = "idade")
    public List<Cliente> getClientsByAge(@RequestParam int idade) {
        return clienteService.getClientsByIdade(idade);
    }

    // add cliente
    @PostMapping
    public Cliente addClient(@RequestBody Cliente cliente) {
        return clienteService.addClient(cliente);
    }

    // vai trazer um cliente com um ID exp
    @PutMapping("/{id}")
    public Cliente getClienteById(@PathVariable int id, @RequestBody Cliente updatedCliente) {
        return clienteService.updateClient(id, updatedCliente);
    }

    // deletar cliente
    @DeleteMapping("/{id}")
    public boolean deleteClient(@PathVariable int id) {
        return clienteService.deleteClient(id);
    }


}
