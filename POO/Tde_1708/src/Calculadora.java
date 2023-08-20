import java.util.List;

public class Calculadora {
    private final Operacao[] operacoes = {
            new Soma(),
            new Subtracao(),
            new Multiplicacao(),
            new Divisao()
    };

    public double realizarOperacao(String operador, List<Double> numeros) {
        for (Operacao operacao : operacoes) {
            if (operador.equals(operacao.getClass().getSimpleName())) {
                return operacao.calcular(numeros);
            }
        }
        return 0.0; // Operação não encontrada
    }
}