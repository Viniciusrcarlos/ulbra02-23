package com.example.tdebancodedados.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "atleta")
@NoArgsConstructor
@Data
public class Atleta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String nome;
    private int idade;
    private String esporte;
    private String equipe;


}
