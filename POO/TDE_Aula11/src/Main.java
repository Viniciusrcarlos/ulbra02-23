public class Main {
    public static void main(String[] args) {

        Banco b1 = new Banco("Santander");

        Conta c1 = new Conta();
        Conta c2 = new Conta();

        c1.depositar(1200);

        b1.adicionarConta(c1);
        b1.adicionarConta(c2);

        b1.depositar(c1, 200);
        b1.sacar(c1, 100);

        System.out.println(b1.consultarSaldo(c1));

        










    }
}
