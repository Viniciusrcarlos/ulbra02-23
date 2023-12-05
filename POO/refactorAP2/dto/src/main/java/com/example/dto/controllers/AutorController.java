package com.example.dto.controllers;

import com.example.dto.entities.Autor;
import com.example.dto.services.AutorService;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorController {

    private AutorService service;

    @Autowired
    public AutorController(AutorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Autor> getAllAltores() {
        return this.service.getAllAltores();
    }
}
