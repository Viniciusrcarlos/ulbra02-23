import java.util.List;
interface Operacao {
    double calcular(List<Double> numeros);
}

// Implementações das operações
class Soma implements Operacao {
    public double calcular(List<Double> numeros) {
        double resultado = 0;
        for (double num : numeros) {
            resultado += num;
        }
        return resultado;
    }
}

class Subtracao implements Operacao {
    public double calcular(List<Double> numeros) {
        double resultado = numeros.get(0);
        for (int i = 1; i < numeros.size(); i++) {
            resultado -= numeros.get(i);
        }
        return resultado;
    }
}

class Multiplicacao implements Operacao {
    public double calcular(List<Double> numeros) {
        double resultado = 1;
        for (double num : numeros) {
            resultado *= num;
        }
        return resultado;
    }
}

class Divisao implements Operacao {
    public double calcular(List<Double> numeros) {
        double resultado = numeros.get(0);
        for (int i = 1; i < numeros.size(); i++) {
            resultado /= numeros.get(i);
        }
        return resultado;
    }
}
