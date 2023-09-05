package Exercicio01;

class Main {
    public static void main(String[] args) {

        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

        Produto produto01 = new Produto("Celular", 3000, "Samsung");
        Produto produto02 = new Produto("Notebook", 5000, "Apple");
        Produto produto03 = new Produto("Computador", 4000, "Dell");

        carrinho.adicionarAoCarrinho(produto01);
        carrinho.adicionarAoCarrinho(produto02);
        carrinho.adicionarAoCarrinho(produto03);

        System.out.println(carrinho.getValorToal());
    }
}