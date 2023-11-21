package com.ulbra.inicioBanco.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "tb_clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private int idade;

    private String profissao;

    public Cliente(String name, int idade, String profissao) {
        this.name = name;
        this.idade = idade;
        this.profissao = profissao;
    }

    // Gets ans Sets
    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }


}
