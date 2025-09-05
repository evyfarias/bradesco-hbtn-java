public void buscaLinear(String nome) {
    System.out.println("Procurando pelo nome: \"" + nome + "\"");
    int posicaoEncontrada = -1;

    for (int i = 0; i < nomes.length; i++) {
        System.out.println("Passando pelo indice:" + i);
        if (nomes[i].equals(nome)) {
            posicaoEncontrada = i;
            System.out.println("Nome pesquisado é " + nome + " que está na posição " + i);
        }
    }

    if (posicaoEncontrada == -1) {
        throw new IllegalArgumentException("O nome " + nome + " não se encontra no array de nomes");
    }
}
