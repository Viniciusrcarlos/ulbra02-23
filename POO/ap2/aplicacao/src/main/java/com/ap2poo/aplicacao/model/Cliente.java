package com.ap2poo.aplicacao.model;
public class Cliente {
    private Long id;
    private String name;
    private int age;
    private String profession;


    // Construtor com parâmetros
    public Cliente(Long id, String name, int age, String profession) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.profession = profession;
    }

    // Getter para o ID
    public Long getId() {
        return id;
    }

    // Setter para o ID
    public void setId(Long id) {
        this.id = id;
    }

    // Getter para o nome
    public String getName() {
        return name;
    }

    // Setter para o nome
    public void setName(String name) {
        this.name = name;
    }

    // Getter para a idade
    public int getAge() {
        return age;
    }

    // Setter para a idade
    public void setAge(int age) {
        this.age = age;
    }

    // Getter para a profissão
    public String getProfession() {
        return profession;
    }

    // Setter para a profissão
    public void setProfession(String profession) {
        this.profession = profession;
    }

}

