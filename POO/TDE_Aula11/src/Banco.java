import java.util.ArrayList;

public class Banco {
    private String nome;
    private ArrayList<Conta> contas = new ArrayList<>();

    //Constructor
    public Banco (String nome) {
        this.nome = nome;
    }

    public void adicionarConta (Conta conta) {
        this.contas.add(conta);
    }
    public double consultarSaldo(Conta conta) {
        for (int i=0; i < contas.size(); i++) {
            if (this.contas.get(i).getNumeroDaConta() == conta.getNumeroDaConta()) {
                return this.contas.get(i).getSaldo();
            }
        }
        return 0.0;
    }


}
