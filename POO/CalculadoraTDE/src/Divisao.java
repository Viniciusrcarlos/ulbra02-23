import java.util.ArrayList;

public class Divisao implements Operador {
    @Override
    public double calcular(ArrayList<Double> lista) {
        if (lista.isEmpty()) {
            throw new IllegalArgumentException("A lista de números não pode estar vazia.");
        }

        double resultado = lista.get(0);
        for (int i = 1; i < lista.size(); i++) {
            resultado /= lista.get(i);
        }

        return resultado;
    }
}