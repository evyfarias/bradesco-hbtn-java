public class Produtor extends Thread {
    private Buffer buffer;

    public Produtor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                buffer.produzir(i);      
                Thread.sleep(1000);      
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
