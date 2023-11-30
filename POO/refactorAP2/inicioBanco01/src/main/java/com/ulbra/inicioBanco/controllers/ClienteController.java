package com.ulbra.inicioBanco.controllers;


import com.ulbra.inicioBanco.dtos.ClienteDTO;
import com.ulbra.inicioBanco.entities.Cliente;
import com.ulbra.inicioBanco.services.ClienteService;
import jakarta.persistence.PostRemove;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ClienteDTO createCliente(@RequestBody ClienteDTO bodyRequest) {
        this.service.createCliente(bodyRequest);
        return bodyRequest;
    }

    @GetMapping
    public ClienteDTO getAllClients() {
        this.serv
    }


}
