import java.util.ArrayList;

abstract class Calculadora {
    private double resultado;

    public double getResultado() {
        return resultado;
    }
    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    abstract void Calcular(Operador operador, ArrayList<Double> lista);
}
