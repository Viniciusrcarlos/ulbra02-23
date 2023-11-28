package com.aula.ulbra.tde.controllers;

import com.aula.ulbra.tde.entities.Author;
import com.aula.ulbra.tde.services.AuthorService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {

    private AuthorService service;

    @Autowired
    public AuthorController(AuthorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return service.getAllAuthors();
    }

}
