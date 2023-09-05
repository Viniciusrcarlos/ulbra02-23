package Exercicio02;

public class Veiculo {
    private String marca;
    private String modelo;
    private double ano;

    boolean on = false;

    public String getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }
    public double getAno() {
        return ano;
    }

    public Veiculo (String marca, String modelo, double ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public void ligar () {
        System.out.println("Ligando o carro...\n");
        on = true;
    }
    public void desligar () {
        if (on == true) {
            System.out.println("Desligando o carro...\n");
        } else {
            System.out.println("O carro já está desligado...\n");
        }
    }
    

}
