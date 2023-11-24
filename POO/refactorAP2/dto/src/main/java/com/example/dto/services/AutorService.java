package com.example.dto.services;

import com.example.dto.entities.Autor;
import com.example.dto.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    AutorRepository autorRepository;

    @Autowired
    public AutorService(AutorRepository repository) {
        this.autorRepository = repository;
    }

    public List<Autor> getAllAltores() {
        return this.autorRepository.save();
    }
}
