public class Numero {
    public static void dividir(int a, int b) {
        int resultadoDivisao = 0;
        try {
            resultadoDivisao = a / b;
        } catch (ArithmeticException e) {
            System.out.println("Nao eh possivel dividir por zero");
        } finally{
            System.out.printf("%d / %d = %d\n", a, b, resultadoDivisao);
        }
    }
}