public class Conta {

    private static int contador = 1;
    private int numeroDaConta;
    private double saldo;

    //gets and sets
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public int getNumeroDaConta() {
        return numeroDaConta;
    }
    public void setNumeroDaConta(int numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    //constructor
    public Conta () {
        saldo = 0;
        numeroDaConta = contador;
        contador++;
    }

    // methods
    public void depositar (int valor) {
        this.saldo += valor;
    }

    public void sacar (int valor) {
        this.saldo -= valor;
    }
    public void transferir (Conta conta, int valor) {
        conta.setSaldo(conta.getSaldo()+valor);
        this.saldo -= valor;
    }

    @Override
    public String toString() {
        return "o que tu quiser";
    }
}
