package com.aula.ulbra.tde.services;

import com.aula.ulbra.tde.controllers.AuthorController;
import com.aula.ulbra.tde.entities.Author;
import com.aula.ulbra.tde.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private AuthorRepository repository;

    @Autowired
    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    public List<Author> getAllAuthors() {
        return this.repository.findAll();
    }
}
