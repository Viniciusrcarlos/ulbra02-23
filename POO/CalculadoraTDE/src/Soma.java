import java.util.ArrayList;

public class Soma implements Operador{

    @Override
    public double calcular(ArrayList<Double> lista) {
        double resultado = 0;
        for (int i = 0; i < lista.size(); i++) {
            resultado += lista.get(i);
        }

        return resultado;
    }
}
