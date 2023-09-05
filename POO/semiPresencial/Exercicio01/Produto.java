package Exercicio01;

public class Produto {
    private String nome;
    private double valor;
    private String descricao;

    public String getNome() {
        return nome;
    }
    public double getValor() {
        return valor;
    }
    public String getDescricao() {
        return descricao;
    }

    public Produto (String nome, double valor, String descricao) {
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
    }
    
}
