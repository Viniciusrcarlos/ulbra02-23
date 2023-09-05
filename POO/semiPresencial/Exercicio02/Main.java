package Exercicio02;

public class Main {
    public static void main(String[] args) {
        Veiculo veiculo01 = new Veiculo("Vw", "Fox", 2010);
        Veiculo veiculo02 = new Veiculo("Toyota", "SW4", 2002);

        veiculo02.ligar();
        veiculo02.desligar();

        veiculo01.desligar();
    }
}
