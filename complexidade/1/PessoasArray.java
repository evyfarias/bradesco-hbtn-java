public class PessoasArray {

    public static int buscaLinear(String[] nomes, String nome) {
        int posicaoEncontrada = -1;

        System.out.println("Procurando pelo nome: \"" + nome + "\"");
        for (int i = 0; i < nomes.length; i++) {
            System.out.println("Passando pelo indice:" + i);
            if (nomes[i].equals(nome)) {
                posicaoEncontrada = i;
                System.out.println("Nome pesquisado é " + nome + " que está na posição " + i);
                // não interrompe o loop, continua até o final
            }
        }

        return posicaoEncontrada; // -1 caso não encontre
    }
}
