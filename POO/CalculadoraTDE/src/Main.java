import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Double> lista = new ArrayList();
        lista.add(20.0);
        lista.add(30.0);

        Soma soma = new Soma();
        Subtracao subtracao = new Subtracao();
        Divisao divisao = new Divisao();
        Multiplicacao multiplicacao = new Multiplicacao();
        Calculadora calculadoraBasica = new CalculadoraBasica();

        calculadoraBasica.Calcular(soma, lista);
        System.out.println(calculadoraBasica.getResultado());

        calculadoraBasica.Calcular(subtracao, lista);
        System.out.println(calculadoraBasica.getResultado());

        calculadoraBasica.Calcular(divisao, lista);
        System.out.println(calculadoraBasica.getResultado());

        calculadoraBasica.Calcular(multiplicacao, lista);
        System.out.println(calculadoraBasica.getResultado());

    }
}
