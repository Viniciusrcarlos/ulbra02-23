package Exercicio01;

import java.util.ArrayList;

public class CarrinhoDeCompras {

    private double valorToal;

    public double getValorToal() {
        return valorToal;
    }

    ArrayList<Produto> produtos = new ArrayList<>();

    public void adicionarAoCarrinho (Produto produto) {
        produtos.add(produto);

        this.valorToal += produto.getValor();
    }
}
