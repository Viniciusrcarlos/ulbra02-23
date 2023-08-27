import java.util.ArrayList;

public class Subtracao implements Operador{

    @Override
    public double calcular(ArrayList<Double> lista) {
        double result = 0;

        for (int i = 0; i < lista.size(); i++) {
            if (i == 0) {
                result = lista.get(i);
            } else {
                result -= lista.get(i);
            }
        }
        return result;
    }
}
