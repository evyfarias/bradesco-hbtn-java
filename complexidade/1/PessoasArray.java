public class PessoasArray {

    private String[] nomes;

    public PessoasArray() {
        nomes = new String[]{
            "Amanda", "Beatriz", "Carlos","Daniela","Eduardo",
            "Fabio","Gustavo", "Hingrid","Isabela","Joao","Leise","Maria",
            "Norberto","Otavio","Paulo", "Quirino","Renata","Sabata",
            "Tais","Umberto","Vanessa","Xavier"
        };
    }

    public void buscaLinear(String nome) {
        int posicaoEncontrada = -1;
        System.out.println("Procurando pelo nome: \"" + nome + "\"");

        for (int i = 0; i < nomes.length; i++) {
            System.out.println("Passando pelo indice:" + i);
            if (nomes[i].equals(nome)) {
                posicaoEncontrada = i;
                System.out.println("Nome pesquisado é " + nome + " que está na posição " + i);
            }
        }

        // Lança a exceção apenas se não encontrou
        if (posicaoEncontrada == -1) {
            throw new IllegalArgumentException("O nome " + nome + " não se encontra no array de nomes");
        }
    }
}
