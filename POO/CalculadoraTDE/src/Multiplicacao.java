import java.util.ArrayList;

public class Multiplicacao implements Operador {
    @Override
    public double calcular(ArrayList<Double> lista) {
        double resultado = 1;
        for (Double numero : lista) {
            resultado *= numero;
        }
        return resultado;
    }
}