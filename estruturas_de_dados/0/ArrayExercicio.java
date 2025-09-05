import java.util.Scanner;

public class ArrayExercicio {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tamanhoArray = 10;
        int[] numeros = new int[tamanhoArray];
        int soma = 0;
        int maiorNumero = Integer.MIN_VALUE;

        System.out.println("Digite 10 numeros inteiros:");
        for (int i = 0; i < tamanhoArray; i++) {
            System.out.print("Digite o numero " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();

            soma += numeros[i];

            if (numeros[i] > maiorNumero) {
                maiorNumero = numeros[i];
            }
        }

        System.out.println("\nConteudo do array:");
        for (int num : numeros) {
            System.out.print(num + " ");
        }

        System.out.println("\nSoma de todos os numeros: " + soma);
        System.out.println("Maior numero no array: " + maiorNumero);

        scanner.close();
    }
}
