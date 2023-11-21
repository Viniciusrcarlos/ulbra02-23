package com.ulbra.inicioBanco.dtos;

public class ClienteDTO {

    private String name;
    private int idade;
    private String profissao;

    public ClienteDTO(String name, int idade, String profissao) {
        this.name = name;
        this.idade = idade;
        this.profissao = profissao;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
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
