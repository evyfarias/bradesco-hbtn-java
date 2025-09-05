public class Program {
    public static void main(String[] args) {
        String[] nomes = {
            "Maria", "João", "Carlos", "Ana", "Paulo", "Fernanda", 
            "Ricardo", "Juliana", "Isabela", "Roberto", "Lucas", "Mariana",
            "Patrícia", "Otavio", "Sofia", "Gabriel", "Mateus", "Beatriz",
            "Larissa", "Pedro", "Camila", "Rafael", "Eduardo"
        };

        long inicio = System.nanoTime();
        PessoasArray.buscaLinear(nomes, "Otavio");
        PessoasArray.buscaLinear(nomes, "Isabela");
        PessoasArray.buscaLinear(nomes, "Anderson");
        long fim = System.nanoTime();

        System.out.println("Tempo de execução: " + (fim - inicio));
    }
}
