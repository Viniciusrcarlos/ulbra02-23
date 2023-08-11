import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> minhaLista = new ArrayList();
        adicionarNaLista(1, minhaLista);
        System.out.println(lerMinhaLista(minhaLista));
        atualizarMinhaLista(minhaLista, 2, 0);
        removerDaLista(minhaLista, 0);
    }

    public static void adicionarNaLista(int elemento, ArrayList<Integer> lista){
        lista.add(elemento);
        System.out.println(lista);
    }
    public static ArrayList<Integer> lerMinhaLista(ArrayList<Integer> lista){
        return lista;
    }
    public static void atualizarMinhaLista(ArrayList<Integer> lista, int elemento, int posicao){
        lista.set(posicao, elemento);
        System.out.println(lista);
    }
    public static void removerDaLista(ArrayList<Integer> lista, int posicao){
        lista.remove(posicao);
        System.out.println(lista);
    }


}
