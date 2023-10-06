public class Main {
    public static void main(String[] args) {

        Banco banco = new Banco("Sicredi");

        Conta c1 = new Conta();
        Conta c2 = new Conta();
        Conta c3 = new Conta();

        c1.depositar(2000);
        c2.depositar(1500);
        c3.depositar(1000);

        banco.adicionarConta(c1);
        banco.adicionarConta(c2);
        banco.adicionarConta(c3);

        System.out.println(banco.consultarSaldo(c1));
        System.out.println(banco.consultarSaldo(c2));
        System.out.println(banco.consultarSaldo(c3));




    }
}
