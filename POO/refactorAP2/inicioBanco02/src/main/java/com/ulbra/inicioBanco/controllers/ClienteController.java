package com.ulbra.inicioBanco.controllers;


import com.ulbra.inicioBanco.dtos.ClienteDTO;
import com.ulbra.inicioBanco.entities.Cliente;
import com.ulbra.inicioBanco.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    ClienteService service;

    @Autowired
    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    public ClienteDTO criarCliente(@RequestBody ClienteDTO bodyRequest) {
        return this.service.createCliente(bodyRequest);

    }

    @GetMapping
    public void getAllClients() {
        service.getAllClients();
    }
}
