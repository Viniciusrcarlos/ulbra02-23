package Exercicio03;

public class Main {
    public static void main(String[] args) {

        ContaCorrente contaCorrente = new ContaCorrente("Vini");
        ContaPoupanca contaPoupanca = new ContaPoupanca("Lauren");
        ContaSalario contaSalario = new ContaSalario("Lucas");

        System.out.println(contaCorrente.consultarSaldo());

    }
}
