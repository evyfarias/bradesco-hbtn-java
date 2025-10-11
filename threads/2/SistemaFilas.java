public class SistemaFilas {
    public static void main(String[] args) {
        Fila fila = new Fila(10);

        Produtor produtor1 = new Produtor(fila);
        Produtor produtor2 = new Produtor(fila);
        Consumidor consumidor1 = new Consumidor(fila);
        Consumidor consumidor2 = new Consumidor(fila);

        produtor1.start();
        produtor2.start();
        consumidor1.start();
        consumidor2.start();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Encerrando sistema de filas...");
        System.exit(0);
    }
}
