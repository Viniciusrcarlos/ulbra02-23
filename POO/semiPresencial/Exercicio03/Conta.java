package Exercicio03;

public abstract class Conta {
    protected String titular;
    protected double saldo;

    public Conta(String titular){
        this.titular = titular;
        this.saldo = 0.0;
    }

    public abstract void depositar(double valor);
    public abstract void sacar(double valor);
    public abstract void transferir(Conta destino, double valor);
    public double consultarSaldo(){
        return saldo;
    };
}
