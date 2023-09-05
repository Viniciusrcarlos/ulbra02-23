package Exercicio03;

public class ContaPoupanca extends Conta{

    public ContaPoupanca (String titular) {
        super(titular);
    }

    @Override
    public void depositar(double valor){
        saldo += valor;
        System.out.println("Valor depositado com sucesso!");
    };

    @Override
    public void sacar(double valor) {
        super.saldo -= valor;
        System.out.println("Saque realizado com sucesso!");
    }

    @Override
    public void transferir(Conta destino, double valor) {
        if (valor >= saldo) {
            destino.depositar(valor);
            System.out.println("Transferido com sucesso!");
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    @Override
    public double consultarSaldo() {
        return saldo;
    }
}
