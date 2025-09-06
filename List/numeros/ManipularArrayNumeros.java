import java.util.List;

public class ManipularArrayNumeros {

    public static int buscarPosicaoNumero(List<Integer> numeros, int numero) {
        return numeros.indexOf(numero); // retorna -1 se não encontrar
    }

    public static void adicionarNumero(List<Integer> numeros, int numero) {
        int posicao = buscarPosicaoNumero(numeros, numero);
        if (posicao != -1) {
            throw new IllegalArgumentException("Numero jah contido na lista");
        }
        numeros.add(numero);
    }

    public static void removerNumero(List<Integer> numeros, int numero) {
        int posicao = buscarPosicaoNumero(numeros, numero);
        if (posicao == -1) {
            throw new IllegalArgumentException("Numero nao encontrado na lista");
        }
        numeros.remove(posicao);
    }

    public static void substituirNumero(List<Integer> numeros, int numeroSubstituir, int numeroSubstituto) {
        int posicao = buscarPosicaoNumero(numeros, numeroSubstituir);
        if (posicao == -1) {
            // não existe -> adiciona substituto
            numeros.add(numeroSubstituto);
        } else {
            // existe -> substitui
            numeros.set(posicao, numeroSubstituto);
        }
    }
}
