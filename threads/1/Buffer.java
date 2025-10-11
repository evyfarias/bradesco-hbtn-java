public class Buffer {
    private int item = -1; 
    
    public synchronized void produzir(int item) throws InterruptedException {
        while (this.item != -1) {
            wait();
        }

        this.item = item;
        System.out.println("Produtor produziu: " + item);
        notify();
    }

    public synchronized int consumir() throws InterruptedException {
        while (this.item == -1) { 
            wait();
        }

        int consumido = this.item;
        this.item = -1;
        System.out.println("Consumidor consumiu: " + consumido);
        notify();

        return consumido;
    }
}
