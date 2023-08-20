import java.util.List;
public class Main {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        List<String> operadores = List.of("+", "-", "*", "/");
        List<List<Double>> numerosList = List.of(
                List.of(2.0, 3.0, 5.0),
                List.of(10.0, 2.0),
                List.of(4.0, 2.5),
                List.of(15.0, 3.0)
        );

        for (int i = 0; i < operadores.size(); i++) {
            String operador = operadores.get(i);
            List<Double> numeros = numerosList.get(i);
            double resultado = calculadora.realizarOperacao(operador, numeros);
            System.out.println("Resultado da operação " + operador + ": " + resultado);
        }
    }
}