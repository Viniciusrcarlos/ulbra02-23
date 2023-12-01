package com.example.tdebancodedados.controllers;

import com.example.tdebancodedados.entities.Atleta;
import com.example.tdebancodedados.repositories.AtletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atleta")
public class AtletaController {

    AtletaRepository repository;

    @Autowired
    public AtletaController(AtletaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Atleta create(@RequestBody Atleta atleta) {
        repository.save(atleta);
        return atleta;
    }

    @GetMapping
    public List<Atleta> findAll() {
        return (List<Atleta>) repository.findAll();
    }

    @DeleteMapping("/{id}")
    public String removeAtleta(@PathVariable long id) {
        repository.deleteById(id);

        return "Atleta deletado com sucesso.";
    }

}
