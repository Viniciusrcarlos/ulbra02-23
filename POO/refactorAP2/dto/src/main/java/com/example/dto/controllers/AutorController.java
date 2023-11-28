package com.example.dto.controllers;

import org.springframework.data.repository.support.Repositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autores")
public class AutorController {
    Repositories repositories;

    @GetMapping
    public void getAllAltores() {
        
    }
}
