package com.aula.aplicacao.model;

public class Cliente {
    private int id;
    private String nome;
    private int idade;
    private String proficao;


    //construtor
    public Cliente(int id, String nome, int idade, String proficao) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.proficao = proficao;
    }

    //gets and sets
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getProficao() {
        return proficao;
    }

    public void setProficao(String proficao) {
        this.proficao = proficao;
    }
}
