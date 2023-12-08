package com.example.as.controller;

import com.example.as.dtos.ClienteResponseDTO;
import com.example.as.entities.Cliente;
import com.example.as.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    //retorna uma lista com todos os clientes  --
    @GetMapping
    public List<ClienteResponseDTO> getAllClients() {
        return clienteService.getAllClients();
    }

    // Retorna um cliente com o id específico
    @GetMapping("/{id}")
    public List<ClienteResponseDTO> getClienteById(@PathVariable long id) {
        return clienteService.getClienteById(id);
    }

    // filtra pela idade
    @GetMapping(params = "idade")
    public List<ClienteResponseDTO> getClientsByAge(@RequestParam int idade) {
        return clienteService.getClientsByIdade(idade);
    }

    // add cliente
    @PostMapping
    public ClienteResponseDTO addClient(@RequestBody ClienteResponseDTO cliente) {
        return clienteService.addClient(cliente);
    }

    // vai trazer atualizar um cliente com um ID exp
    @PutMapping("/{id}")
    public String getClienteById(@PathVariable long id, @RequestBody Cliente updatedCliente) {
        clienteService.updateClient(id, updatedCliente);

        return "Cliente atualizado";
    }

    // deletar cliente
    @DeleteMapping("/{id}")
    public String deleteClient(@PathVariable long id) {
        clienteService.deleteClient(id);

        return "Cliente deletado!";
    }


}
